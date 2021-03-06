package com.example.a3dolphinsextra.network

import com.example.a3dolphinsextra.global.GlobalClass
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkConfig {



    companion object {

        fun getInterceptor(): OkHttpClient {

            val logging =  HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY


            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

            return okHttpClient
        }


        fun getRetrofit(): Retrofit {

            return Retrofit.Builder()
                    .baseUrl(GlobalClass.serverUrl)
                    .client(getInterceptor())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        }

        fun getService() = getRetrofit().create(NetworkService::class.java)


    }


}