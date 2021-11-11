package com.example.a3dolphinsextra.model

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class LoginModel(

    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String

)
