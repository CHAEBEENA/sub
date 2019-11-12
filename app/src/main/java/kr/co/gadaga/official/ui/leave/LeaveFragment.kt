package kr.co.gadaga.official.ui.leave

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kr.co.gadaga.official.R

class LeaveFragment : Fragment() {

    companion object {
        fun newInstance() = LeaveFragment()
    }

    private lateinit var viewModel: LeaveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_leave, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LeaveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
