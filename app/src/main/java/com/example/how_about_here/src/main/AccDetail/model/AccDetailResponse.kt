package com.example.how_about_here.src.main.AccDetail.model


data class AccDetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)