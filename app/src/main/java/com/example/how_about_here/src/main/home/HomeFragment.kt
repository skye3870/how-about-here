package com.example.how_about_here.src.main.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentHomeBinding


class HomeFragment :
        BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {
    var img=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        waitGuest()
        binding.homeHotel.setOnClickListener(){

        }
    }
/*****************************************************************************************************/
    private val mDelayHandler: Handler by lazy {
        Handler()
    }

    private fun waitGuest(){
        if(img==1) {
            mDelayHandler.postDelayed(::showImg1, 5000)// 5초 후에 showGuest 함수를 실행한다.
        }else if (img==2){
            mDelayHandler.postDelayed(::showImg2, 5000)
        }
    }

    private fun showImg1(){
        // 실제 반복하는 코드를 여기에 적는다
        img=2
        binding.homeImageview.setImageResource(R.drawable.home_page2)
        waitGuest() // 코드 실행뒤에 계속해서 반복하도록 작업한다.
    }
    private fun showImg2(){
        // 실제 반복하는 코드를 여기에 적는다
        img=1
        binding.homeImageview.setImageResource(R.drawable.home_page1)
        waitGuest() // 코드 실행뒤에 계속해서 반복하도록 작업한다.
    }
}