package kr.co.gadaga.official.ui.announcement

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updatePadding
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

import kr.co.gadaga.official.R
import kr.co.gadaga.official.data.model.Announcement
import kr.co.gadaga.official.databinding.FragmentAnnouncementBinding
import kr.co.gadaga.official.ext.doOnApplyWindowInsets
import kr.co.gadaga.official.ext.viewModelProvider

class AnnouncementFragment : Fragment(), AnnouncementActionHandler {

    companion object {
        fun newInstance() = AnnouncementFragment()
    }

    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var tagRecyclerViewPool : RecyclerView.RecycledViewPool
    var mapFeatureEnabled:Boolean = false


    private lateinit var viewModel: AnnouncementViewModel
    private lateinit var adapter: AnnouncementAdapter
    private lateinit var binding: FragmentAnnouncementBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnnouncementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AnnouncementViewModel::class.java)

        adapter = AnnouncementAdapter(
            this,
            savedInstanceState
        )
        binding.announcementList.adapter = adapter

        binding.announcementList.doOnApplyWindowInsets { v, insets, padding ->
            v.updatePadding(bottom = padding.bottom + insets.systemWindowInsetBottom)
        }

        viewModel = viewModelProvider(viewModelFactory)




    }

    override fun dismissAnnouncementInfoCard() {

    }

    override fun launchAnnouncementWebsite() {

    }

    override fun openAnnouncementOnMap() {

    }

    override fun startAccouncement(announcement: Announcement) {

    }

}
