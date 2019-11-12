package kr.co.gadaga.official.ui.map

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import kr.co.gadaga.official.R

class MapFragment : Fragment(), OnMapReadyCallback {

    private var mView: View? = null

    private lateinit var viewModel: MapViewModel

    private lateinit var mContext: Context

    private lateinit var mParentActivity: AppCompatActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* block Navigation Component to inflate view */
        if(mView == null) mView = inflater.inflate(R.layout.fragment_map, container, false)

        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mContext = requireContext()

        mParentActivity = requireActivity() as AppCompatActivity

        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)

        val mapFragment = mParentActivity.supportFragmentManager.findFragmentById(R.id.mapFragment) as com.naver.maps.map.MapFragment?
            ?: com.naver.maps.map.MapFragment.newInstance().also { mParentActivity.supportFragmentManager.beginTransaction().add(R.id.mapFragment, it).commit() }

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: NaverMap) {

    }
}
