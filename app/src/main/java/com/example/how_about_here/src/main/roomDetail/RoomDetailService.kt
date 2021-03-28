package com.example.how_about_here.src.main.roomDetail

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.roomDetail.modelReservationResult.ReservationResultRequest
import com.example.how_about_here.src.main.roomDetail.modelReservationResult.ReservationResultResponse
import com.example.how_about_here.src.main.roomDetail.modelRoomDetail.RoomDetailResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomDetailService(val view: RoomDetailActivitytView) {

    /*fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(JoinRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onGetUserSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }*/


    @RequiresApi(Build.VERSION_CODES.O)
    fun tryPostReservation(id: Int, idx: Int, check_in: String, check_out: String, reservationResultRequest: ReservationResultRequest) {
        val reservationRetrofitInterface =
                ApplicationClass.sRetrofit.create(RoomDetailRetrofitInterface::class.java)
        reservationRetrofitInterface.postReservation(id,idx,check_in,check_out, reservationResultRequest)
                .enqueue(object : Callback<ReservationResultResponse> {
                    override fun onResponse(call: Call<ReservationResultResponse>,
                                            response: Response<ReservationResultResponse>) {
                        view.onSuccessResult(response.body() as ReservationResultResponse)
                    }

                    override fun onFailure(call: Call<ReservationResultResponse>, t: Throwable) {
                        view.onFailure(t.message ?: "통신 오류")
                    }


                })
    }
    fun tryGetRoomDetail( id: Int, idx: Int) {
        val roomDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(RoomDetailRetrofitInterface::class.java)
        roomDetailRetrofitInterface.getRoomDetail(id,idx)
            .enqueue(object : Callback<RoomDetailResponse> {


                override fun onResponse(
                    call: Call<RoomDetailResponse>,
                    response: Response<RoomDetailResponse>
                ) {
                    view.onSuccess(response.body() as RoomDetailResponse)
                }

                override fun onFailure(call: Call<RoomDetailResponse>, t: Throwable) {
                    view.onFailure(t.message ?: "통신 오류")
                }


            })
    }


}
