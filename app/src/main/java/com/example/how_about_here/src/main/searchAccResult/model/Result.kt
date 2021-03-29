package com.example.how_about_here.src.main.searchAccResult.model


import com.google.gson.annotations.SerializedName

data class Result(
    val acmdIdx: Int,
    val acmdName: String,
    val cnt: Int,
    val mainImage: Any,
    val nearInfo: String,
    val rating: Double,
    val typeName: String
)