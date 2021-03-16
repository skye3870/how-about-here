package com.example.how_about_here.src.main

import android.os.Bundle
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityMainBinding
import com.example.how_about_here.src.dashboard.MylocaFragment
import com.example.how_about_here.src.main.home.HomeFragment
import com.example.how_about_here.src.main.home.HotelFragment
import com.example.how_about_here.src.main.home.MoreFragment
import com.example.how_about_here.src.main.home.MyFragment
import com.example.how_about_here.src.notifications.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(//bottom_nav

            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        //return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_my_loca -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MylocaFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_my -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyFragment())
                                .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_more -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MoreFragment())
                                .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })
    }
    fun showFragmentHotel(){
        val hotelFragment = HotelFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.main_frm, hotelFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}