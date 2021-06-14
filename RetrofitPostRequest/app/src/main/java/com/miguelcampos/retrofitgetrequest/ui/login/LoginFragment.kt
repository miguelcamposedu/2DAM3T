package com.miguelcampos.retrofitgetrequest.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelcampos.retrofitgetrequest.data.login.LoginService
import com.miguelcampos.retrofitgetrequest.data.login.request.LoginDto
import com.miguelcampos.retrofitgetrequest.data.login.response.LoginResponse
import com.miguelcampos.retrofitgetrequest.databinding.FragmentLoginBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : Fragment() {
    private lateinit var v: View
    private lateinit var binding: FragmentLoginBinding
    private lateinit var client: OkHttpClient
    private lateinit var retrofit: Retrofit
    private lateinit var loginService: LoginService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        v = binding.root

        client = OkHttpClient.Builder().build()

        retrofit = Retrofit.Builder()
                //TODO cuidado!!!!!! 10.0.2.2
            .baseUrl("http://reqres.in/api/") // change this IP for testing by your actual machine IP
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        loginService = retrofit.create(LoginService::class.java)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()) {
                val loginData = LoginDto(
                    email,
                    pass
                )
                loginService.doLogin(loginData).enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        TODO("Not yet implemented")
                        if(response.code() == 200) {

                        } else {

                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        TODO("Si hay un problema en la comunicación")
                    }
                })
            }
        }

        return v
    }

}