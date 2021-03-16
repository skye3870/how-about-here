package com.example.how_about_here.src.main.my

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.*


class LoginEmailActivity : BaseActivity<ActivityLoginEmailBinding>(ActivityLoginEmailBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.login.setOnClickListener(){
            finish()
        }

    }


}