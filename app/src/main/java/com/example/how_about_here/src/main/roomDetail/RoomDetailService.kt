package com.example.how_about_here.src.main.roomDetail

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.roomDetail.model.GetRoomDetailRequest
import com.example.how_about_here.src.main.roomDetail.model.RoomDetailResponse


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

    fun tryGetRoomDetail(getRoomDetailRequest: GetRoomDetailRequest) {
        val roomDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(RoomDetailRetrofitInterface::class.java)
        roomDetailRetrofitInterface.getRoomDetail(getRoomDetailRequest)
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
