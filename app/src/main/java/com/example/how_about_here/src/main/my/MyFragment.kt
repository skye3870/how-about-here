package com.example.how_about_here.src.main.my

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentMyBinding


import com.example.how_about_here.src.main.login.JoinLoginKakaoActivity
import com.example.how_about_here.src.main.reserveCheck.ReserveCheckActivity

class MyFragment :
        BaseFragment<FragmentMyBinding>(FragmentMyBinding::bind, R.layout.fragment_my) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var check_login =false
        if(ApplicationClass.X_ACCESS_TOKEN!="X-ACCESS-TOKEN"){
            binding.join1.text=""
            binding.join2.text=ApplicationClass.sSharedPreferences.getString("email","email")
            check_login=true
        }

        binding.joinLogin.setOnClickListener() {
            val intent = Intent(context, JoinLoginKakaoActivity::class.java)
            startActivity(intent)
        }

        binding.textMyReserve.setOnClickListener(){
            if(check_login){
                val intent = Intent(context, ReserveCheckActivity::class.java)
                startActivity(intent)
            }else{
                showCustomToast("로그인이 필요합니다.")
            }
        }


    }





}