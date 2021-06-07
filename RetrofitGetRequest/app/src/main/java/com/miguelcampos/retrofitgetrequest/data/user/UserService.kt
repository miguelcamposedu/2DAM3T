package com.miguelcampos.retrofitgetrequest.data.user

import com.miguelcampos.retrofitgetrequest.data.user.response.UserListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    fun getUserList(@Query("page") numPage: String): Call<UserListResponse>
}