package com.example.how_about_here.src.main.AccDetail.modelAccDetail


data class Room(

    val extraInfo: String,
    val price: Int,
    //@SerializedName("RoomInformation")
    val roomInformation: String,
    val roomName: String,
    val roomIdx : Int
)