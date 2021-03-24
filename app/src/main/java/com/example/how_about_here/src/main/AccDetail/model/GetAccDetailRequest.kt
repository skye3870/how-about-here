package com.example.how_about_here.src.main.AccDetail.model

import com.google.gson.annotations.SerializedName

data class GetAccDetailRequest(
        @SerializedName("id") val id: Int//리싸이클 뷰에서 호텔 아이디

)