package com.example.how_about_here.src.main.login.models

import com.google.gson.annotations.SerializedName

data class ResultUserLogin(
        @SerializedName("userId") val userId: Int,
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
)
