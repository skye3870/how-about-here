package com.example.how_about_here.src.main.hotel


import android.os.Bundle
import android.os.Looper
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentHotelBinding
import android.os.Handler
import com.example.how_about_here.src.dashboard.MylocaFragment
import com.example.how_about_here.src.main.MainActivity
import com.example.how_about_here.src.main.home.HomeFragment

class HotelFragment :
        BaseFragment<FragmentHotelBinding>(FragmentHotelBinding::bind, R.layout.fragment_hotel) {


    lateinit var adapter: hotelViewpagerAdapter
    var currentPosition=0
    val handler=Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    binding.myLoca.setOnClickListener {
        //실패

    }


    var list = mutableListOf<Int>()

        list.add(R.drawable.hotel_slider3)
        list.add(R.drawable.hotel_slider2)
        list.add(R.drawable.hotel_slider1)

        adapter= hotelViewpagerAdapter(context)
        adapter.setContentList(list)
        binding.hotelViewpager.adapter=adapter

        //binding.hotelViewpager.animation

        val thread=Thread(PagerRunnable())
        thread.start()
    }

















    //페이지 변경하기
    fun setPage(){
        if(currentPosition==5) currentPosition=0
        binding.hotelViewpager.setCurrentItem(currentPosition,true)
        currentPosition+=1
    }

    //2초 마다 페이지 넘기기
    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){
                Thread.sleep(2000)
                handler.sendEmptyMessage(0)
            }
        }
    }

}