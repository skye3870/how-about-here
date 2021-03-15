package com.example.how_about_here.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil.bind
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentMyBinding

import com.example.how_about_here.src.main.JoinLoginActivity

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