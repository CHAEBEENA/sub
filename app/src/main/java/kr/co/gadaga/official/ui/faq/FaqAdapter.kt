package kr.co.gadaga.official.ui.faq

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.gadaga.official.R
import kr.co.gadaga.official.data.model.Faq
import kr.co.gadaga.official.databinding.ItemFaqBinding

class FaqAdapter : RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {

    var mList = mutableListOf<Faq>()

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        return FaqViewHolder(ItemFaqBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))

    }

    class FaqViewHolder(
        private val binding:ItemFaqBinding
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

        fun bind(item:Faq) {
            binding.apply {
                faq = item
                executePendingBindings()
            }

        }

    }
}