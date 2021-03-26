package com.example.how_about_here.src.main.searchAccResult


import com.example.how_about_here.src.main.roomDetail.model.GetRoomDetailRequest
import com.example.how_about_here.src.main.roomDetail.model.RoomDetailResponse
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse
import retrofit2.Call
import retrofit2.http.*


interface SearchAccResultRetrofitInterface {
    @GET("/search?keyword="+"{keyword}")
    fun getSearch(@Query ("keyword") keyword: String): Call<SearchAccResultResponse>


    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/
    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/

}