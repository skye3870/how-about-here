package com.example.how_about_here.src.main.AccDetail.modelAccDetail


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("avg(R.rating)")
    val avgRRating: Double
)