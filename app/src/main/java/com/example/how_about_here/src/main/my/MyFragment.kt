package com.example.how_about_here.src.main.my

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentMyBinding


import com.example.how_about_here.src.main.login.JoinLoginKakaoActivity

class MyFragment :
        BaseFragment<FragmentMyBinding>(FragmentMyBinding::bind, R.layout.fragment_my) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(ApplicationClass.X_ACCESS_TOKEN!="X-ACCESS-TOKEN"){
            binding.join1.text=""
            binding.join2.text=ApplicationClass.sSharedPreferences.getString("email","email")

        }



        binding.joinLogin.setOnClickListener() {
            val intent = Intent(context, JoinLoginKakaoActivity::class.java)
            startActivity(intent)
        }

    }





}