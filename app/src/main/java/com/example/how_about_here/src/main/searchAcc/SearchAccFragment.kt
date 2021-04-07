package com.example.how_about_here.src.main.searchAcc


import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.SearchView
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentSearchAccBinding
import com.example.how_about_here.src.main.searchAccResult.SearchAccResultFragment



class SearchAccFragment :
        BaseFragment<FragmentSearchAccBinding>(FragmentSearchAccBinding::bind, R.layout.fragment_search_acc) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //fragmentManager?.beginTransaction()?.replace(R.id.search_frm,SearchAccResultFragment())?.commitAllowingStateLoss()
                fragmentManager?.beginTransaction()?.add(R.id.search_frm, SearchAccResultFragment()
                        .apply {
                            arguments = Bundle().apply {
                                putString("keyword", binding.search.query.toString())
                            }
                        })
                        ?.addToBackStack(null)?.commit()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })



    }



}



