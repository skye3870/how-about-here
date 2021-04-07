package com.example.how_about_here.src.main.myloca.model


import com.google.gson.annotations.SerializedName

data class mylocaResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)