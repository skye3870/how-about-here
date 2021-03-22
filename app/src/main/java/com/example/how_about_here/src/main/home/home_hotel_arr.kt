package com.example.how_about_here.src.main.home

import com.example.how_about_here.R

//goodsList.add(Goods(R.drawable.apple,"apple", "문화", 10000))
data class HomeHotel(val img: Int?,val special :String? ,val name: String?, val star: Double?, val review:Int, val where : String?, val price_orgin: Int?, val price:Int?,val id:Int)//, val name: String?, val cate: String?, val price: Int?
    //val homeBlackArr=ArrayList<home_black>()
    //val goodsList=ArrayList<Goods>()


    val HomeHotelArr =arrayListOf(

            HomeHotel(R.drawable.home_hotel_card1, "[반짝특가]","호텔리베라",9.1, 1774, "청담역 도보 5분",251000,69900,1),
            HomeHotel(R.drawable.home_hotel_card2, "[하루특가]","호텔피제이명동",9.4, 995, "을지로4가역 도보 5분",225000,63200,2),
            HomeHotel(R.drawable.home_hotel_card3, "","블룸비스타 호텔",9.3, 377, "들꽃 수목원 15분",200000,89900,3)

)


