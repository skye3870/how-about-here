package com.example.how_about_here.src.main.AccDetail.model


import com.google.gson.annotations.SerializedName

data class accdetail(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)