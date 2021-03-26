package com.example.how_about_here.src.main.searchAccResult.model


import com.google.gson.annotations.SerializedName

data class SearchAccResultResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)