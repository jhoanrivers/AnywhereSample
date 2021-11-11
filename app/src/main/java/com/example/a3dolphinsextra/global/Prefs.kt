package com.example.a3dolphinsextra.global

import android.content.Context
import android.content.SharedPreferences


val credentialPref = "CREDENTIAL_PREFERENCE"

class Prefs(context: Context) {


    private val TOKEN = "token"

    private val preference: SharedPreferences = context.getSharedPreferences(credentialPref,Context.MODE_PRIVATE)

    var token: String
        get() = preference.getString(TOKEN,"token")!!
        set(value) = preference.edit().putString(TOKEN,value).apply()


}