package com.example.how_about_here.src.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentHomeBinding
import com.example.how_about_here.databinding.FragmentSearchBinding

class SearchFragment :
        BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}