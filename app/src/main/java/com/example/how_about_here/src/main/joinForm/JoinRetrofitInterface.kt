package com.example.how_about_here.src.main.joinForm


import com.example.how_about_here.src.main.joinForm.models.PostSignUpRequest
import com.example.how_about_here.src.main.joinForm.models.UserResponse
import retrofit2.Call
import retrofit2.http.*


interface JoinRetrofitInterface {
    /*@GET("/users")
    fun getUsers() : Call<UserResponse>*/

    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>

}