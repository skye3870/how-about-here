package com.example.how_about_here.src.main.roomDetail


import com.example.how_about_here.src.main.roomDetail.model.RoomDetailResponse
import retrofit2.Call
import retrofit2.http.*


interface RoomDetailRetrofitInterface {
    @GET("/acmd/"+"{id}"+"/rooms/"+"{idx}")
    fun getRoomDetail(@Path("id") id: Int, @Path("idx") idx: Int): Call<RoomDetailResponse>


    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/
    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/

}