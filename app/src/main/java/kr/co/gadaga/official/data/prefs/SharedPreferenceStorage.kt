package kr.co.gadaga.official.data.prefs

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPreferenceStorage(context: Context): PreferenceStorage {

    private val preferences: Lazy<SharedPreferences> = lazy {
        context.applicationContext.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
    }

    override var onboardingCompleted by BooleanPreference(preferences, PREF_ONBOARDING, false)

    override var signedIn by BooleanPreference(preferences, PREF_SIGNED_IN, false)

    companion object {
        const val PREFS_NAME = "gadaga"
        const val PREF_ONBOARDING = "pref_onboarding"
        const val PREF_SIGNED_IN = "pref_signed_in"
    }
}