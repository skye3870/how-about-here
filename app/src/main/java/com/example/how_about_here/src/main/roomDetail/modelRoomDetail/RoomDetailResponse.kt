package com.example.how_about_here.src.main.roomDetail.modelRoomDetail


data class RoomDetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)