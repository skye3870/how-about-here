package com.example.how_about_here.src.main.joinForm.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String//,
        //@SerializedName("result") val result: ArrayList<ResultUser>
)
