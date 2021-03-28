package com.example.how_about_here.src.main.resultReservation

import android.os.Bundle
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivitySuccessReservationBinding

class ResultReservationActivity : BaseActivity<ActivitySuccessReservationBinding>(ActivitySuccessReservationBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.textResult.text=intent.getStringExtra("result")

        binding.check.setOnClickListener(){

            finish()

        }
    }
}