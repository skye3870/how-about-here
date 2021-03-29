package com.example.how_about_here.src.main.reserveCheck.model


data class ReserveCheckResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)