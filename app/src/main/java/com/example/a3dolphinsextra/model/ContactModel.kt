package com.example.a3dolphinsextra.model

import com.google.gson.annotations.SerializedName


data class ContactResponse(
        @SerializedName("status")
        val status: String,

        @SerializedName("data")
        val data: List<ContactModel>,

        @SerializedName("hasMore")
        val hasMore: Boolean,

        @SerializedName("totalResults")
        val totalResults: Int
)



data class ContactModel(

        @SerializedName("id")
        val id: String,

        @SerializedName("spell")
        val spell: List<String>,

        @SerializedName("owner")
        val owner: String,

        @SerializedName("createdDate")
        val createdDate: Long,

        @SerializedName("modifiedDate")
        val modifiedDate: Long,

        @SerializedName("modifiedBy")
        val modifiedBy: String,

        @SerializedName("contactEmail")
        val contactEmail: List<String>,

        @SerializedName("contactFirstName")
        val contactFirstName: String,

        @SerializedName("contactLastName")
        val contactLastName: String,

        @SerializedName("maxFollower")
        val maxFollower: Long,

        @SerializedName("additionalField")
        val additionalField: List<String>,

        @SerializedName("tag")
        val tag: Int

)
