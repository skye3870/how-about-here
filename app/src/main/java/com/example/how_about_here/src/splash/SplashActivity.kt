package com.example.how_about_here.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivitySplashBinding
import com.example.how_about_here.src.main.MainActivity



class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500)
    }
}