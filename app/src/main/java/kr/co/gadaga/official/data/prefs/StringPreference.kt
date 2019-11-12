package kr.co.gadaga.official.data.prefs

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringPreference(
    private val prefences: Lazy<SharedPreferences>,
    private val name: String,
    private val defaultValue: String
) : ReadWriteProperty<Any, String?> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String? = prefences.value.getString(name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) = prefences.value.edit { putString(name, value) }
}