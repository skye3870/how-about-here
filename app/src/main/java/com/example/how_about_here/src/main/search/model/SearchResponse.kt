package com.example.how_about_here.src.main.search.model


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)