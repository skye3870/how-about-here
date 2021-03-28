package com.example.how_about_here.src.main.AccDetail.modelAccDetail


import com.google.gson.annotations.SerializedName

data class Information(
    val acmdIntro: String,
    @SerializedName("Accommodationformation")
    val accommodationformation: List<String>,

    @SerializedName("Checkingformation")
    val checkingformation: List<String>,
    @SerializedName("RefundInformation")
    val refundInformation: List<String>
)