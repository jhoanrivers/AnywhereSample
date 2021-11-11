package com.example.a3dolphinsextra.model

import com.google.gson.annotations.SerializedName

data class TaskListResponse (

        @SerializedName("status")
        val status: String,
        @SerializedName("data")
        val data: List<TaskModel>,
        @SerializedName("hasMore")
        val hasMore: Boolean,
        @SerializedName("nextIndex")
        val nextIndex: Int,
        @SerializedName("prevIndex")
        val prevIndex: Int,
        @SerializedName("totalResult")
        val totalResult : Int
        )


data class TaskModel (
        @SerializedName("id")
        val id: String,
        @SerializedName("owner")
        val owner: String,
        @SerializedName("createdDate")
        val createdDate: Long,
        @SerializedName("createdBy")
        val createdBy: String,
        @SerializedName("modifiedDate")
        val modifiedDate: Long,
        @SerializedName("modifiedBy")
        val modifiedBy: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("taskName")
        val taskName: String,
        @SerializedName("deleted")
        val deleted: Boolean,
        @SerializedName("dueDate")
        val dueDate: Long,
        @SerializedName("highPriority")
        val highPriority: Boolean,
        )


data class CreatedBy(

        @SerializedName("firstName")
        val firstName: String,

        @SerializedName("lastName")
        val lastName: String,

        @SerializedName("nickName")
        val nickName: String,

        @SerializedName("id")
        val id: String,

        @SerializedName("avatar")
        val avatar: String

)