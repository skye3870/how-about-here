package com.example.how_about_here.src.main.search

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.SearchView
import androidx.core.content.ContextCompat

import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment

import com.example.how_about_here.databinding.FragmentSearchAccBinding
import com.example.how_about_here.src.main.AccDetail.AccDetailActivity
import com.example.how_about_here.src.main.hotel.HotelFragment


class SearchAccFragment :
        BaseFragment<FragmentSearchAccBinding>(FragmentSearchAccBinding::bind, R.layout.fragment_search_acc) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                //Performs search when user hit the search button on the keyboard
                val intent = Intent(context, SearchAccResultFragment::class.java)
                intent.putExtra("search", binding.search.query.toString())

                parentFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchAccResultFragment())
                        .commitAllowingStateLoss()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
            /*override fun onQueryTextChange(p0: String?): Boolean {
                //Start filtering the list as user start entering the characters
                adapter.filter.filter(p0)
                return false
            }*/
        })





        /*binding.search.setOnQueryTextFocusChangeListener() {
            val search_text = binding.search.query.toString()*/



    }

}



