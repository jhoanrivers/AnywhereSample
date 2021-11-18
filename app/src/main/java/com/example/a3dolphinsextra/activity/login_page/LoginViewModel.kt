package com.example.a3dolphinsextra.activity.login_page

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.a3dolphinsextra.global.prefs
import com.example.a3dolphinsextra.model.AuthResponse
import com.example.a3dolphinsextra.model.LoginModel
import com.example.a3dolphinsextra.model.UserResponse
import com.example.a3dolphinsextra.network.NetworkConfig
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {



    suspend fun doLogin(
            email: String,
            password: String
    ): String {
        var result: String = ""

        GlobalScope.launch {
            suspend {
                NetworkConfig.getService().doGetAuth(LoginModel(email,password))
                        .enqueue(object: Callback<AuthResponse>{

                            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                                result = response.body()!!.token
                            }
                            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                                Log.d("Auth Response", t.localizedMessage)
                                result = "Wrong username or password"
                            }
                        });
            }.invoke()
        }
        return result
    }



    private fun getMobileSession(email: String, password: String, token: String): Boolean {

        var result: Boolean = false

        var userMap: Map<String, String> = mapOf(
                "email" to email,
                "password" to password,
                "action" to "login"
        )
        var newToken = "Bearer $token"

        GlobalScope.launch {
            suspend {
                NetworkConfig.getService()
                        .doLogin(userMap, newToken)
                        .enqueue(object: Callback<UserResponse> {
                            override fun onResponse(
                                    call: Call<UserResponse>,
                                    response: Response<UserResponse>)
                            {
                                val id: String = response.body()!!.data.id
                                val firstName: String = response.body()!!.data.firstName
                                val email: String = response.body()!!.data.email
                                val password: String = password
                                val username: String = response.body()!!.data.username
                                val role: String = response.body()!!.data.role
                                val mobileSession: Boolean = response.body()!!.data.mobileSession
                                val profileImage: String = response.body()!!.data.profileImage
                                prefs.saveUserData(id,email,firstName,username,mobileSession,profileImage,role)
                                prefs.saveUserPassword(password)
                                prefs.token = token
                                result = true
                            }

                            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                                Log.e("Login Response", t.localizedMessage)
                                result = false
                            }
                        })

            }.invoke()
        }
        return result
    }


}