package com.example.how_about_here.src.main.roomDetail.model

import com.google.gson.annotations.SerializedName

data class GetRoomDetailRequest(
        @SerializedName("id") val id: Int,//리싸이클 뷰에서 호텔 아이디
        @SerializedName("idx") val idx: Int//리싸이클 뷰에서 룸 아이디

)