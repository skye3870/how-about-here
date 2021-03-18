package com.example.how_about_here.src.main.home


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentHomeBinding



class HomeFragment :
        BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeHotel.setOnClickListener {
            parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, HotelFragment())
                    .commitAllowingStateLoss()
        }

        binding.motelFragment.textViewMotel.setOnClickListener {
            binding.scrollView.smoothScrollTo(0, 5000)
        }

    }
























    /*****************************************************************************************************/
    /*override fun onStop() {
        super.onStop()
        Log.d("dddddd","dddddddddddd")
        img=4000
    }

    private val mDelayHandler: Handler by lazy {
        Handler()
    }

    private fun waitGuest(){
        if(img==1) {
            mDelayHandler.postDelayed(::showImg1, 5000)// 5초 후에 showGuest 함수를 실행한다.
        }else if (img==2){
            mDelayHandler.postDelayed(::showImg2, 5000)
        }else if (img==4000){
            //다른프레그넌트 일때 에러남
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

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }*/
}