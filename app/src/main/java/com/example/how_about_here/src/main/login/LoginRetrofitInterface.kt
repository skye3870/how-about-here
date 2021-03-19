package com.example.how_about_here.src.main.login

import com.example.how_about_here.src.main.joinForm.models.PostSignUpRequest
import com.example.how_about_here.src.main.joinForm.models.UserResponse
import com.example.how_about_here.src.main.login.models.PostUserLoginRequest
import com.example.how_about_here.src.main.login.models.UsersLoginResponse
import retrofit2.Call
import retrofit2.http.*

interface LoginRetrofitInterface {
    @POST("/login")
    fun postUsersLogin(@Body params: PostUserLoginRequest) : Call<UsersLoginResponse>
}
