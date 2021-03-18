package com.example.how_about_here.src.main.login.models

import com.google.gson.annotations.SerializedName

data class UsersLoginResponse(
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String,
        @SerializedName("result") val result: ArrayList<ResultUserLogin>
)
