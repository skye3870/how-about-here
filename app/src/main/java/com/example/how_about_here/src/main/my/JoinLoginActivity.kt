package com.example.how_about_here.src.main.my

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinLoginBinding
import com.example.how_about_here.databinding.ActivityMainBinding


class JoinLoginActivity : BaseActivity<ActivityJoinLoginBinding>(ActivityJoinLoginBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.joinEmail.setOnClickListener(){
            //이메일로 가입
            var intent= Intent()
        }

        binding.myBtnLoginKakao.setOnClickListener(){
            //카카오로그인 연동
        }

    }


}