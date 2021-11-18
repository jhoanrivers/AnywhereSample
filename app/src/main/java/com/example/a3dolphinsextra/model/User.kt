package com.example.a3dolphinsextra.model

import com.google.gson.annotations.SerializedName


data class UserResponse(

        @SerializedName("status")
        val status: String,

        @SerializedName("data")
        val data: User,

)



data class User(

        @SerializedName("id")
        val id: String,

        @SerializedName("firstName")
        val firstName: String,

        @SerializedName("email")
        val email: String,

        @SerializedName("password")
        val password: String,

        @SerializedName("userName")
        val username: String,

        @SerializedName("role")
        val role: String,

        @SerializedName("mobileSession")
        val mobileSession: Boolean,

        @SerializedName("profileImage")
        val profileImage: String




)
