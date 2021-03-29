package com.example.how_about_here.src.main.searchAcc


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.FragmentManager
import com.example.how_about_here.R
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentSearchAccBinding
import com.example.how_about_here.src.main.searchAccResult.SearchAccResultFragment


class SearchAccFragment :
        BaseFragment<FragmentSearchAccBinding>(FragmentSearchAccBinding::bind, R.layout.fragment_search_acc) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, SearchAccResultFragment())
                .commitAllowingStateLoss()

       /* super.onViewCreated(view, savedInstanceState)



        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                //Performs search when user hit the search button on the keyboard
//                if (bestCities.contains(p0)) {
//                    adapter.filter.filter(p0)
//                } else {
//                    Toast.makeText(this@MainActivity, "No match found", Toast.LENGTH_SHORT).show()
//                }

                val intent = Intent(context, SearchAccResultFragment::class.java)
                intent.putExtra("keyword", binding.search.toString())


                parentFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchAccResultFragment())
                        .commitAllowingStateLoss()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                //Start filtering the list as user start entering the characters

                return false
            }
        })*/



    }

}



