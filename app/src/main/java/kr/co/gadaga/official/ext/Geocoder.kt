package kr.co.gadaga.official.ext

import android.content.Context
import android.location.Geocoder
import java.util.*

// TODO(필요없음)
fun Geocoder.initialize(context: Context, locale: Locale = Locale.KOREA): Geocoder = Geocoder(context, Locale.KOREA)

fun Geocoder.convertLatLngToAddress(latitude: Double, longitude: Double): String
        = getFromLocation(latitude, longitude, 1)[0].getAddressLine(0).split(" ").drop(3).joinToString(separator = " ")