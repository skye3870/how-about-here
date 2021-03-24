package com.example.how_about_here.src.main.AccDetail


import com.example.how_about_here.src.main.AccDetail.model.AccDetailResponse
import com.example.how_about_here.src.main.AccDetail.model.GetAccDetailRequest
import retrofit2.Call
import retrofit2.http.*


interface AccDetailRetrofitInterface {
    @GET("/acmd/{id}")
    fun getAccDetail(@Path("id") id: Int): Call<AccDetailResponse>

    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/

}