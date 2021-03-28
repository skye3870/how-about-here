package com.example.how_about_here.src.main.resultReservation.modelReservationResult

import com.google.gson.annotations.SerializedName
import retrofit2.http.Headers

data class ReservationResultRequest(
        @SerializedName("reserveName") val reserveName: String,
        @SerializedName("phoneNumber") val phoneNumber: String,



)