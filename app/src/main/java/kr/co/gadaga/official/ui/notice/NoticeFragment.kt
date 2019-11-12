package kr.co.gadaga.official.ui.notice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.gadaga.official.R
import kr.co.gadaga.official.data.model.Notice
import kr.co.gadaga.official.databinding.FragmentNoticeBinding

class NoticeFragment : Fragment() {

    private lateinit var binding: FragmentNoticeBinding
    private val adapter = NoticeAdapter()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {
        binding = FragmentNoticeBinding.inflate(inflater,container,false).apply {
            noticeList.adapter = adapter
            noticeList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val list : MutableList<Notice> = (mutableListOf(
            Notice("id1", "title", "20191111", "description", "new"),
            Notice("id2", "title2", "20191111", "description2", "new"),
            Notice("id3", "title2", "20191111", "description2", "new")
        ))

        adapter.mList = list
        adapter.notifyDataSetChanged()

        adapter.addItem(Notice("id1", "title", "20191111", "description", "new"))
        adapter.addItem(Notice("id2", "title2", "20191111", "description2", "new"))
        adapter.addItem(Notice("id3", "title2", "20191111", "description2", "new"))

    }
}