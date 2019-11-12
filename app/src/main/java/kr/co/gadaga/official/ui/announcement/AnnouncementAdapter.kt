package kr.co.gadaga.official.ui.announcement

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.gadaga.official.R
import kr.co.gadaga.official.data.model.Announcement
import kr.co.gadaga.official.databinding.ItemAccouncementBinding
import kr.co.gadaga.official.ext.compatRemoveIf
import kr.co.gadaga.official.ext.executeAfter

internal class AnnouncementAdapter (
    private val announcementActionHandler: AnnouncementActionHandler,
    savedState: Bundle?
) : ListAdapter<Any,AnnouncementViewHolder>(AnnouncementDiffCallback){

    companion object {
        private const val STATE_KEY_EXPANDED_IDS = "AnnouncementAdapter:expandedIds"
    }

    private var expandedIds = mutableSetOf<String>()

    init {
        savedState?.getStringArray(STATE_KEY_EXPANDED_IDS)?.let {
            expandedIds.addAll(it)
        }
    }

    fun onSaveInstanceState(state: Bundle) {
        state.putStringArray(STATE_KEY_EXPANDED_IDS, expandedIds.toTypedArray())
    }

    override fun submitList(list: List<Any>?) {
        // Clear out any invalid IDs
        if (list == null) {
            expandedIds.clear()
        } else {
            val ids = list.filterIsInstance<Announcement>().map { it.id }
            expandedIds.compatRemoveIf { it !in ids }
        }
        super.submitList(list)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is Announcement -> R.layout.item_accouncement
            else -> throw IllegalStateException("Unknown type: ${item::class.java.simpleName}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_accouncement -> AnnouncementViewHolder.AnnountcementItemHolder(
                ItemAccouncementBinding.inflate(inflater, parent, false).apply {
                    actionHandler = announcementActionHandler
                }
            )
            else -> throw IllegalArgumentException("Invalid viewType")
        }
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder, position: Int) {
        if (holder is AnnouncementViewHolder.AnnountcementItemHolder) {
            bindCodelabItemHolder(holder, getItem(position) as Announcement)
        }
    }

    private fun bindCodelabItemHolder(holder: AnnouncementViewHolder.AnnountcementItemHolder, item: Announcement) {
        holder.binding.executeAfter {
            announcement = item
            isExpanded = expandedIds.contains(item.id)
        }
        holder.itemView.setOnClickListener {
            val parent = holder.itemView.parent as? ViewGroup ?: return@setOnClickListener
            val expanded = holder.binding.isExpanded ?: false
            if (expanded) {
                expandedIds.remove(item.id)
            } else {
                expandedIds.add(item.id)
            }
            val transition = TransitionInflater.from(holder.itemView.context)
                .inflateTransition(R.transition.announcement_toggle)
            TransitionManager.beginDelayedTransition(parent, transition)
            holder.binding.executeAfter {
                isExpanded = !expanded
            }
        }
    }
}


internal sealed class AnnouncementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class AnnountcementItemHolder(
        val binding: ItemAccouncementBinding
    ) : AnnouncementViewHolder(binding.root)

}

internal object AnnouncementDiffCallback : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is Announcement && newItem is Announcement -> oldItem.id == newItem.id
            else -> false
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is Announcement && newItem is Announcement -> oldItem == newItem
            else -> true
        }
    }
}

@BindingAdapter("announcementDate")
fun announcementDuration(view:TextView, createDate: String) {
    view.text = view.resources.getString(R.string.announcement_date,createDate)
}