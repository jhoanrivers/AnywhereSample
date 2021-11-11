package com.example.a3dolphinsextra.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("token")
    var token: String,
    @SerializedName("expireAt")
    var expireAt: String

)
