package com.example.how_about_here.src.main.roomDetail


import com.example.how_about_here.src.main.resultReservation.modelReservationResult.ReservationResultRequest
import com.example.how_about_here.src.main.resultReservation.modelReservationResult.ReservationResultResponse
import com.example.how_about_here.src.main.roomDetail.modelRoomDetail.RoomDetailResponse
import retrofit2.Call
import retrofit2.http.*


interface RoomDetailRetrofitInterface {
    @GET("/acmd/"+"{id}"+"/rooms/"+"{idx}")
    fun getRoomDetail(@Path("id") id: Int, @Path("idx") idx: Int): Call<RoomDetailResponse>


    @POST("/acmd/"+"{id}"+"/rooms/"+"{idx}"+"/reservation")//?checkIn={check_in}&checkOut={check_out}
    fun postReservation(@Path("id") id: Int,
                        @Path("idx") idx: Int,

                        //체크인,체크아웃
                        @Query("checkIn") check_in: String,
                        @Query("checkOut") check_out: String,
                        //닉네임,전화번호
                        @Body params: ReservationResultRequest
            //,@Headers ("X-ACCESS-TOKEN") XACCESSTOKEN : String



    ): Call<ReservationResultResponse>


    /*@POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<UserResponse>*/

}