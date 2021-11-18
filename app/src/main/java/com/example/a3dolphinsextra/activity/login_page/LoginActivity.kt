package com.example.a3dolphinsextra.activity.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a3dolphinsextra.activity.HomeActivity
import com.example.a3dolphinsextra.databinding.ActivityLoginBinding
import com.example.a3dolphinsextra.global.prefs
import com.example.a3dolphinsextra.model.AuthResponse
import com.example.a3dolphinsextra.model.LoginModel
import com.example.a3dolphinsextra.network.NetworkConfig
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        onClickButton()
    }


    private fun onClickButton() {

        email = binding.usernameTxt.text.toString()
        password = binding.passwordTxt.text.toString()

        binding.loginBtn.setOnClickListener {

            GlobalScope.launch {
                var response: String = loginViewModel.doLogin(email, password)
            }


            if (response) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this,"Wrong Username or Password", Toast.LENGTH_SHORT).show()
            }

        }

    }







}