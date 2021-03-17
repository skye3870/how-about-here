package com.example.how_about_here.src.main.join.models

import com.google.gson.annotations.SerializedName

data class ResultUser(
        @SerializedName("userId") val userId: Int,
        @SerializedName("email") val email: String
)
