package com.example.a3dolphinsextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a3dolphinsextra.databinding.ActivityLoginBinding
import com.example.a3dolphinsextra.model.AuthResponse
import com.example.a3dolphinsextra.model.LoginModel
import com.example.a3dolphinsextra.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickButton()
    }


    private fun onClickButton() {
        binding.loginBtn.setOnClickListener {

            binding.loadingPgb.visibility = View.VISIBLE
            var dataUser = LoginModel(binding.usernameTxt.text.toString(), binding.passwordTxt.text.toString())
            NetworkConfig().getService().doGetAuth(dataUser).enqueue(object: Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    binding.loadingPgb.visibility = View.GONE
                    //prefs.token = response.body()?.token ?: "token"
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.putExtra("token", response.body()?.token)
                    startActivity(intent)
                }
                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                   Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })


        }

    }







}