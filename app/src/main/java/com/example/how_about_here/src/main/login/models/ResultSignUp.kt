package com.example.how_about_here.src.main.login.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
        @SerializedName("jwt") val jwt: String
)