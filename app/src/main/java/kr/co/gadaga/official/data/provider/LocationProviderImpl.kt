package kr.co.gadaga.official.data.provider

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.location.FusedLocationProviderClient
import kr.co.gadaga.official.ext.convertLatLngToAddress

class LocationProviderImpl (
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val geocoder: Geocoder,
    context: Context
) {

    private val appContext = context.applicationContext

    /* 위치 트래킹 */


    /* 현재 위치 */
    fun currentLocation() = 0

    /* 기기 마지막 위치 */
    fun lastLocation() {
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                val address = geocoder.convertLatLngToAddress(location.latitude, location.longitude)

            }.addOnFailureListener { exception ->
                exception.printStackTrace()
            }
    }
}