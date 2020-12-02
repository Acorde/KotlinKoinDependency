package com.igor.koindependency

import android.content.Context
import android.preference.PreferenceManager

const val PROFILE_NAME = "profile_name"

class AppPreferencesConstractor(context: Context) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveProfileName(profileName: String) =
        sharedPreferences.edit().putString(PROFILE_NAME, profileName).apply()

    fun getProfileName(): String = sharedPreferences.getString(PROFILE_NAME, "") ?: ""
}