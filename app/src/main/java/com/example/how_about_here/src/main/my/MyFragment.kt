package com.example.how_about_here.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentMyBinding

import com.example.how_about_here.src.main.join.JoinLoginActivity

class MyFragment :
        BaseFragment<FragmentMyBinding>(FragmentMyBinding::bind, R.layout.fragment_my) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.joinLogin.setOnClickListener() {
            val intent = Intent(context, JoinLoginActivity::class.java)
            startActivity(intent)
        }

    }
}