package com.example.how_about_here.src.main.join

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinAgreeBinding
import com.example.how_about_here.databinding.ActivityJoinLoginBinding
import com.example.how_about_here.databinding.ActivityJoinSuccessBinding
import com.example.how_about_here.databinding.ActivityMainBinding


class JoinSuccessActivity : BaseActivity<ActivityJoinSuccessBinding>(ActivityJoinSuccessBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.check.setOnClickListener(){
            finish()
        }

    }


}