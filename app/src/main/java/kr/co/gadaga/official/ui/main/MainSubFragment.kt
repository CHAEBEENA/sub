package kr.co.gadaga.official.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Overlay
import com.naver.maps.map.overlay.OverlayImage
import kr.co.gadaga.official.R
import kr.co.gadaga.official.databinding.FragmentMainSubBinding
import kr.co.gadaga.official.ext.*

class MainSubFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMainSubBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var mContext: Context

    private lateinit var mParentActivity: AppCompatActivity

    private lateinit var mNaverMap: NaverMap

    private val mMarkerClickListener by lazy {
        Overlay.OnClickListener {
            if(it is Marker) {
                /* 카메라 이동 */
                mNaverMap.moveTo(it.position)
            }

            true // 클릭 이벤트
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainSubBinding.inflate(inflater, container, false).apply {

        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mContext = requireContext()

        mParentActivity = requireActivity() as AppCompatActivity

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val mapFragment = mParentActivity.supportFragmentManager.findFragmentById(R.id.mapFragment) as MapFragment?
            ?: MapFragment.newInstance().also { mParentActivity.supportFragmentManager.beginTransaction().add(R.id.mapFragment, it).commit() }

        mapFragment.getMapAsync(this)

        init()
    }

    private fun init() {
        /* 드로어 */
        binding.apply {
            drawerImageView.setOnClickListener {
                /* 배경 효과 */
                drawerBackground.animate().alpha(1f).setDuration(500L).setInterpolator(AccelerateDecelerateInterpolator()).withStartAction { drawerBackground.visible() }.start()

                /* 드로어 메뉴 나타남 */
                rootLayout.update {
                    setGuidelinePercent(R.id.drawerGuidelineStart, 0f)
                    setGuidelinePercent(R.id.drawerGuidelineEnd, .8f)

                    TransitionManager.beginDelayedTransition(rootLayout, ChangeBounds().apply {
                        interpolator = AccelerateDecelerateInterpolator()
                        duration = 500L
                    })
                }
            }

            drawerBackground.setOnClickListener {
                /* 배경 효과 */
                drawerBackground.animate().alpha(0f).setDuration(500L).setInterpolator(AccelerateDecelerateInterpolator()).withEndAction { drawerBackground.gone() }.start()

                /* 드로어 메뉴 사라짐 */
                rootLayout.update {
                    setGuidelinePercent(R.id.drawerGuidelineStart, -.8f)
                    setGuidelinePercent(R.id.drawerGuidelineEnd, 0f)

                    TransitionManager.beginDelayedTransition(rootLayout, ChangeBounds().apply {
                        interpolator = AccelerateDecelerateInterpolator()
                        duration = 500L
                    })
                }
            }
        }
    }

    override fun onMapReady(map: NaverMap) {
        mNaverMap = map.apply {
            /* 지도 UI 세팅 */
            uiSettings.apply {
                isZoomControlEnabled = false
                isRotateGesturesEnabled = false
                isScaleBarEnabled = false
                isCompassEnabled = false
                isTiltGesturesEnabled = false
            }

            /* 지도 이동 */
            addOnCameraIdleListener {
                val center = center()

                // 쿼리한 중심점에서 일정반경 멀어지면 `이 근처 가게보기` 버튼 보이기

            }

            /* 마커 클릭 */
            val marker = Marker(LatLng(37.533121, 127.006535))
            marker.onClickListener = mMarkerClickListener
            marker.icon = OverlayImage.fromResource(R.drawable.ic_home)
            marker.map = this
        }
    }
}
