package kr.co.gadaga.official.ui.faq

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.gadaga.official.R
import kr.co.gadaga.official.data.model.Faq
import kr.co.gadaga.official.databinding.FragmentFaqBinding

class FaqFragment : Fragment() {

    private val adapter = FaqAdapter()
    private lateinit var binding : FragmentFaqBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {
        binding = FragmentFaqBinding.inflate(inflater,container,false).apply {
            faqList.adapter = adapter
            faqList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val list : MutableList<Faq> = mutableListOf(
            Faq("id1","faq1","des1"),
            Faq("id2","faq2","des2")
        )

        adapter.mList = list
        adapter.notifyDataSetChanged()

    }
}