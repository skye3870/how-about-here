package com.example.how_about_here.src.main.home

import com.example.how_about_here.R

//goodsList.add(Goods(R.drawable.apple,"apple", "문화", 10000))
data class Goods(val img: Int?, val name: String?, val cate: String?, val price: Int?)
    val myGoodsList=ArrayList<Goods>()
    //val goodsList=ArrayList<Goods>()


    val goodsList =arrayListOf(
        /*Goods(R.drawable.apple,"apple", "문화", 10000),
        Goods(R.drawable.banana,"banana", "여가", 20000),
        Goods(R.drawable.lemon,"lemon", "삽니다", 30000),
        Goods(R.drawable.mango,"mango", "가전", 40000),
        Goods(R.drawable.orange,"orange", "기타", 50000),
        Goods(R.drawable.grape,"grape", "소품", 60000),
        Goods(R.drawable.pear,"pear", "남성", 70000),
        Goods(R.drawable.kiwi,"kiwi", "여성", 80000),
        Goods(R.drawable.melon,"melon", "가구", 90000),
        Goods(R.drawable.tomato,"tomato", "스포츠", 100000),*/
        Goods(R.drawable.home_auto_slide1,"cherry", "게임", 110000),
        Goods(R.drawable.email_login,"peach", "디지털", 120000)
)


