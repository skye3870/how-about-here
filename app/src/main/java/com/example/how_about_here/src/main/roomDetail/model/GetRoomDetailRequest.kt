package com.example.how_about_here.src.main.roomDetail.model

import com.google.gson.annotations.SerializedName

data class GetRoomDetailRequest(
        @SerializedName("id") val id: Int,
        @SerializedName("idx") val idx: Int

)