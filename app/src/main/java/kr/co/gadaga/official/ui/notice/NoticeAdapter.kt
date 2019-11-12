package kr.co.gadaga.official.ui.notice

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.gadaga.official.R
import kr.co.gadaga.official.data.model.Notice
import kr.co.gadaga.official.databinding.ItemNoticeBinding

class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    var mList = mutableListOf<Notice>()



    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        Log.e("tag",position.toString())
      //  val notice = mList[position]
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    fun addItem(item:Notice){
        mList.add(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(ItemNoticeBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))
    }

    class NoticeViewHolder(
        private val binding: ItemNoticeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var expanded = false

        init {
            val transition = TransitionInflater.from(itemView.context).inflateTransition(R.transition.info_card_toggle)
            binding.titleContainer.setOnClickListener {
                expanded = !expanded
                transition.duration = if(expanded) 300L else 200L
                TransitionManager.beginDelayedTransition(itemView.parent as ViewGroup, transition)
                binding.cardDescription.visibility = if(expanded) View.VISIBLE else View.GONE
                binding.expandIcon.rotationX = if(expanded) 180f else 0f
            }
        }

        fun bind(item:Notice) {
            Log.e("tag",item.toString())
            binding.apply {
                    notice = item
                    executePendingBindings()
                }

            }
        }
    }


/*private class NoticeDiffCallback: DiffUtil.ItemCallback<Notice>() {
    override fun areContentsTheSame(oldItem: Notice, newItem: Notice): Boolean {
        return false
    }

    override fun areItemsTheSame(oldItem: Notice, newItem: Notice): Boolean {
        return false
    }
}*/
