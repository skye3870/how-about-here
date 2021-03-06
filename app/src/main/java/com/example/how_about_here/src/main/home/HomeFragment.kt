package com.example.how_about_here.src.main.home


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.how_about_here.R
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentHomeBinding
import com.example.how_about_here.src.main.hotel.HotelFragment


class HomeFragment :
        BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {
    lateinit var adapter: homeViewpagerAdapter
    var currentPosition=0
    val handler= Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    private val thread=Thread(PagerRunnable())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.blackFragment.rvBlack.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.blackFragment.rvBlack.setHasFixedSize(true)
        binding.blackFragment.rvBlack.adapter = HomeBlackAdapter(HomeBlackArr)

        binding.hotelResortFragment.rvHotel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.hotelResortFragment.rvHotel.setHasFixedSize(true)
        binding.hotelResortFragment.rvHotel.adapter = HomeHotelAdapter(HomeHotelArr)


        var list = mutableListOf<Int>()

        list.add(R.drawable.home_viewpage1)
        list.add(R.drawable.home_viewpage2)
        list.add(R.drawable.home_viewpage3)

        adapter= homeViewpagerAdapter(context)
        adapter.setContentList(list)
        binding.homeImageSlider.adapter=adapter

        //binding.hotelViewpager.animation

        thread.start()


        binding.homeHotel.setOnClickListener {
            parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, HotelFragment())
                    .commitAllowingStateLoss()
        }

        binding.motelFragment.textViewMotel.setOnClickListener {
            binding.scrollView.smoothScrollTo(0,2000)
        }
        binding.motelFragment.textViewHotelResort.setOnClickListener {
            binding.scrollView.smoothScrollTo(0, 3600)
        }
        binding.motelFragment.textViewBlack.setOnClickListener {
            binding.scrollView.smoothScrollTo(0, 5500)
        }



    }

    override fun onStop() {
        super.onStop()
        thread.interrupt()
    }

    //????????? ????????????
    private fun setPage(){
        if(currentPosition==3) currentPosition=0
        binding.homeImageSlider.setCurrentItem(currentPosition, true)
        currentPosition+=1
    }

    //2??? ?????? ????????? ?????????
    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){

                try {
                    // do something
                    Thread.sleep(2000)
                    handler.sendEmptyMessage(0)
                } catch (ex: InterruptedException) {
                    thread.interrupt()
                }

            }
        }
    }




    /*****************************************************************************************************/
    /*override fun onStop() {
        super.onStop()
        Log.d("dddddd","dddddddddddd")
        img=4000
    }

    private val mDelayHandler: Handler by lazy {
        Handler()
    }

    private fun waitGuest(){
        if(img==1) {
            mDelayHandler.postDelayed(::showImg1, 5000)// 5??? ?????? showGuest ????????? ????????????.
        }else if (img==2){
            mDelayHandler.postDelayed(::showImg2, 5000)
        }else if (img==4000){
            //????????????????????? ?????? ?????????
        }
    }

    private fun showImg1(){
        // ?????? ???????????? ????????? ????????? ?????????
        img=2
        binding.homeImageview.setImageResource(R.drawable.home_page2)
        waitGuest() // ?????? ???????????? ???????????? ??????????????? ????????????.
    }
    private fun showImg2(){
        // ?????? ???????????? ????????? ????????? ?????????
        img=1
        binding.homeImageview.setImageResource(R.drawable.home_page1)
        waitGuest() // ?????? ???????????? ???????????? ??????????????? ????????????.
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }*/
}