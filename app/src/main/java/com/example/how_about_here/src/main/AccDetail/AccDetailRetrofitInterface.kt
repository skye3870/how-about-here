package com.example.how_about_here.src.main.AccDetail


import com.example.how_about_here.src.main.AccDetail.modelAccDetail.AccDetailResponse
import com.example.how_about_here.src.main.AccDetail.modelReviews.AccReviewsResponse
import retrofit2.Call
import retrofit2.http.*


interface AccRetrofitInterface {
    @GET("/acmd/{id}")
    fun getAccDetail(@Path("id") id: Int): Call<AccDetailResponse>

    @GET("/acmd/{id}/reviews")
    fun getAccReviews(@Path("id") id: Int): Call<AccReviewsResponse>

    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/

}