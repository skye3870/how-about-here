package com.example.how_about_here.src.main.AccDetail.model


import com.google.gson.annotations.SerializedName

data class Information(
    @SerializedName("Accommodationformation")
    val accommodationformation: List<String>,
    val acmdIntro: String,
    @SerializedName("Checkingformation")
    val checkingformation: List<String>,
    @SerializedName("RefundInformation")
    val refundInformation: List<String>
)