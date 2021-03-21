package com.example.how_about_here.src.main

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityCouponPopupBinding
import com.example.how_about_here.databinding.ActivityCouponPopupBinding.inflate
import com.example.how_about_here.src.main.hotel.HotelFragment

class HomeCouponPopupActivity : BaseActivity<ActivityCouponPopupBinding>(ActivityCouponPopupBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, HotelFragment::class.java)
        startActivity(intent)


    }
}