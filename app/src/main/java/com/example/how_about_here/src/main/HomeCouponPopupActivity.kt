package com.example.how_about_here.src.main

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityCouponPopupBinding
import com.example.how_about_here.databinding.ActivityCouponPopupBinding.inflate
import com.example.how_about_here.databinding.ActivityMainBinding
import com.example.how_about_here.src.dashboard.MylocaFragment
import com.example.how_about_here.src.main.home.HomeFragment
import com.example.how_about_here.src.main.home.HotelFragment
import com.example.how_about_here.src.main.home.MoreFragment
import com.example.how_about_here.src.main.home.MyFragment
import com.example.how_about_here.src.notifications.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeCouponPopupActivity : BaseActivity<ActivityCouponPopupBinding>(ActivityCouponPopupBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, HotelFragment::class.java)
        startActivity(intent)


    }
}