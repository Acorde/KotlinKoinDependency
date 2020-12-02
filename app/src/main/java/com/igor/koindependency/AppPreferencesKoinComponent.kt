package com.igor.koindependency

import android.content.Context
import android.preference.PreferenceManager
import org.koin.core.KoinComponent
import org.koin.core.inject

class AppPreferencesKoinComponent : KoinComponent {
    private val context: Context by inject()

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveProfileName(profileName: String) =
        sharedPreferences.edit().putString(PROFILE_NAME, profileName).apply()

    fun getProfileName(): String = sharedPreferences.getString(PROFILE_NAME, "") ?: ""
}