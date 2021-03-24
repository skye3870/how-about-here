package com.example.how_about_here.src.main.AccDetail.model


import com.google.gson.annotations.SerializedName

data class AccDetailResponse(

        @SerializedName("code") val code: Int,
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("message") val message: String,
        @SerializedName("result") val result: Result

)