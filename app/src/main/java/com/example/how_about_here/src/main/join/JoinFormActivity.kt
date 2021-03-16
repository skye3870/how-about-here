package com.example.how_about_here.src.main.join

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinFormBinding


class JoinFormActivity : BaseActivity<ActivityJoinFormBinding>(ActivityJoinFormBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.agree.setOnClickListener(){
            val intent = Intent(this, JoinSuccessActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}