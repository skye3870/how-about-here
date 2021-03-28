package com.example.how_about_here.src.main.roomDetail.modelReservationResult

import com.google.gson.annotations.SerializedName

data class ReservationResultRequest(
        @SerializedName("reserveName") val reserveName: String,
        @SerializedName("phoneNumber") val phoneNumber: String

)