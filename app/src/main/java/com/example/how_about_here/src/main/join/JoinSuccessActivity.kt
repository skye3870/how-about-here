package com.example.how_about_here.src.main.join

import android.os.Bundle
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinSuccessBinding


class JoinSuccessActivity : BaseActivity<ActivityJoinSuccessBinding>(ActivityJoinSuccessBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.check.setOnClickListener(){
            finish()
        }

    }


}