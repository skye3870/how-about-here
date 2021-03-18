package com.example.how_about_here.src.main.joinForm.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
        @SerializedName("userEmail") val email: String,
        @SerializedName("password") val password: String,
        @SerializedName("againPwd") val confirmPassword: String,
        @SerializedName("nickName") val nickname: String,
        @SerializedName("phoneNumber") val phoneNumber: String
)