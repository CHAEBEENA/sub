package kr.co.gadaga.official.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kr.co.gadaga.official.R

/**
 *  지도 없는 버전
 */
class MainFragment : Fragment() {

    private var mView: View? = null

    private lateinit var viewModel: MainViewModel

    private lateinit var mContext: Context

    private lateinit var mParentActivity: AppCompatActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* TODO(네비게이션 로직 체크) */
        if(mView == null) mView = inflater.inflate(R.layout.fragment_main, container, false)
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mContext = requireContext()

        mParentActivity = requireActivity() as AppCompatActivity

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        init()
    }

    private fun init() {

    }
}
