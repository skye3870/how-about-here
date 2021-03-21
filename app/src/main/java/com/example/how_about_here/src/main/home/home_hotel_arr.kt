package com.example.how_about_here.src.main.home

import com.example.how_about_here.R

//goodsList.add(Goods(R.drawable.apple,"apple", "문화", 10000))
data class HomeHotel(val img: Int?,val name: String?, val star: Double?, val review:Int, val where : String?, val price_orgin: Int?, val price:Int?)//, val name: String?, val cate: String?, val price: Int?
    //val homeBlackArr=ArrayList<home_black>()
    //val goodsList=ArrayList<Goods>()


    val HomeHotelArr =arrayListOf(

            HomeHotel(R.drawable.home_hotel_card1, "호텔리베라",9.1, 1774, "청담역 도보 5분",251000,69900),
            HomeHotel(R.drawable.home_hotel_card1, "호텔리베라",9.1, 1774, "청담역 도보 5분",251000,69900),
            HomeHotel(R.drawable.home_hotel_card1, "호텔리베라",9.1, 1774, "청담역 도보 5분",251000,69900)

)


