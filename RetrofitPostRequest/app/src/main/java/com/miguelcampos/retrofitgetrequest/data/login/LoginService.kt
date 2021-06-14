package com.miguelcampos.retrofitgetrequest.data.login

import com.miguelcampos.retrofitgetrequest.data.login.request.LoginDto
import com.miguelcampos.retrofitgetrequest.data.login.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface LoginService {


    @Headers("Content-Type: application/json")
    @POST("login")
    fun doLogin(@Body userData: LoginDto): Call<LoginResponse>
}