package com.example.how_about_here.src.main.hotel


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentHotelBinding

class HotelFragment :
        BaseFragment<FragmentHotelBinding>(FragmentHotelBinding::bind, R.layout.fragment_hotel) {


    lateinit var adapter: hotelViewpagerAdapter
    var currentPosition=0
    val handler=Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    private val thread=Thread(PagerRunnable())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    var list = mutableListOf<Int>()

        list.add(R.drawable.hotel_slider3)
        list.add(R.drawable.hotel_slider2)
        list.add(R.drawable.hotel_slider1)

        adapter= hotelViewpagerAdapter(context)
        adapter.setContentList(list)
        binding.hotelViewpager.adapter=adapter

        //binding.hotelViewpager.animation

        thread.start()
    }
    override fun onStop() {
        super.onStop()
        thread.interrupt()
    }

    //페이지 변경하기
    private fun setPage(){
        if(currentPosition==5) currentPosition=0
        binding.hotelViewpager.setCurrentItem(currentPosition, true)
        currentPosition+=1
    }

    //2초 마다 페이지 넘기기
    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){

                try {
                    // do something
                    Thread.sleep(2000)
                    handler.sendEmptyMessage(0)
                } catch (ex: InterruptedException) {
                    thread.interrupt()
                }

            }
        }
    }

}