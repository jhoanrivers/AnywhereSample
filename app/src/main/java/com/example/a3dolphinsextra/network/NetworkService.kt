package com.example.a3dolphinsextra.network

import com.example.a3dolphinsextra.model.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface NetworkService {


    /*
    get auth
     */
    @Headers("Accept: application/json")
    @POST("/dolphin/apiv1/graph/auth")
    fun doGetAuth(
        @Body requestBody: LoginModel): Call<AuthResponse>


    /*
    Get all task
     */
    @GET("/dolphin/apiv1/graph/tasks")
    fun getListTask(
            @Query("order") order: String,
            @Query("start") start: Int,
            @Query("count") count: Int,
            @Query("status") status: String,
            @Query("orderBy") orderBy: String,
            @Header("Authorization") token: String,
            ) : Call<TaskListResponse>



    /*
    Get all contact
     */
    @GET("/dolphin/apiv1/graph/contacts/all")
    fun getContacts(
            @Header("Authorization") token: String
    ): Call<ContactResponse>


    @Headers("Accept: application/json")
    @POST("/dolphin/apiv1/graph/users/mobile/session")
    fun doLogin(
            @Body data: Map<String, String>,
            @Header("Authorization") token: String,
    ) : Call<UserResponse>


}