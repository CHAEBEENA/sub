package kr.co.gadaga.official.ext

import androidx.annotation.DrawableRes
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.NaverMap
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage

/* 카메라 이동 */
fun NaverMap.moveTo(latLng: LatLng, cameraAnimation: CameraAnimation = CameraAnimation.Easing) = moveCamera(CameraUpdate.scrollTo(latLng).animate(cameraAnimation))
fun NaverMap.moveTo(latitude: Double, longitude: Double, cameraAnimation: CameraAnimation = CameraAnimation.Easing) = moveCamera(CameraUpdate.scrollTo(LatLng(latitude, longitude)).animate(cameraAnimation))

fun NaverMap.moveToMarkerCenter(marker: Marker) {
    moveTo(marker.position)
}

/* 중심좌표 */
fun NaverMap.center() = cameraPosition.target

fun Marker.add(latLng: LatLng, @DrawableRes resourceId: Int? = null, mNaverMap: NaverMap) = apply {
    position = latLng
    map = mNaverMap

    resourceId?.let { resourceId -> icon = OverlayImage.fromResource(resourceId) }
}

fun Marker.remove(mNaverMap: NaverMap) = apply { map = null }