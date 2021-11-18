package com.example.a3dolphinsextra.global

import android.content.Context
import android.content.SharedPreferences
import com.example.a3dolphinsextra.model.User


val credentialPref = "CREDENTIAL_PREFERENCE"
val USER_PROFILE = "USER_DATA"

val FIRST_NAME = "firstName"
val EMAIL = "email"
val PASSWORD = "password"
val ID = "ID"
val MOBILE_SESSION = "mobileSession"
val PROFILE_IMAGE = "profileImage"
val USER_NAME = "userName"
val ROLE = "role"


class Prefs(context: Context) {


    private val TOKEN = "token"

    private val preference: SharedPreferences = context.getSharedPreferences(credentialPref,Context.MODE_PRIVATE)
    private val userData: SharedPreferences = context.getSharedPreferences(USER_PROFILE, Context.MODE_PRIVATE)


    var token: String
        get() = preference.getString(TOKEN,"token")!!
        set(value) = preference.edit().putString(TOKEN,value).apply()



    fun saveUserData(
            id: String,
            email: String,
            firstName: String,
            userName: String,
            mobileSession: Boolean,
            profileImage: String,
            role: String
    ) {
        val editor: SharedPreferences.Editor = userData.edit()
        editor.putString(ID, id)
        editor.putString(EMAIL,email)
        editor.putString(FIRST_NAME, firstName)
        editor.putBoolean(MOBILE_SESSION,mobileSession)
        editor.putString(PROFILE_IMAGE, profileImage)
        editor.putString(USER_NAME, userName)
        editor.putString(ROLE, role)
        editor.apply()
        editor.commit()
    }



    fun saveUserPassword(
            password: String
    ) {
        val editor: SharedPreferences.Editor = userData.edit()
        editor.putString(PASSWORD, password)
        editor.apply()
        editor.commit()
    }



    fun getDataUser() : User{
        val id: String = userData.getString(ID, "id")!!
        val firstName: String = userData.getString(FIRST_NAME, "firstName")!!
        val email: String = userData.getString(EMAIL, "email")!!
        val password: String = userData.getString(PASSWORD, "password")!!
        val mobileSession: Boolean = userData.getBoolean(MOBILE_SESSION, false)
        val profileImage: String = userData.getString(PROFILE_IMAGE, "profileImage")!!
        val userName: String = userData.getString(USER_NAME, "userName")!!
        val role: String = userData.getString(ROLE, "role")!!

        return User(
                id,
                firstName,
                email,
                password,
                userName,
                role,
                mobileSession,
                profileImage
        )
    }



}