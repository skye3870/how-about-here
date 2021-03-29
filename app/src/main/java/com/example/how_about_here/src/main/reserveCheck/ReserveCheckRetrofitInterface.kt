package com.example.how_about_here.src.main.reserveCheck


import com.example.how_about_here.src.main.reserveCheck.model.ReserveCheckResponse
import retrofit2.Call
import retrofit2.http.*


interface ReserveCheckRetrofitInterface {
    @GET("/reservations")
    fun getReserveCheck(): Call<ReserveCheckResponse>

    /*@GET("/acmd/{id}/reviews")
    fun getAccReviews(@Path("id") id: Int): Call<AccReviewsResponse>*/

    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/

}