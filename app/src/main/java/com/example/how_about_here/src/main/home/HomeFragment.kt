package com.example.how_about_here.src.main.home


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.how_about_here.R
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
            binding.scrollView.smoothScrollTo(0, 500)
        }
        binding.motelFragment.textViewHotelResort.setOnClickListener {
            binding.scrollView.smoothScrollTo(0, 1000)
        }
        binding.motelFragment.textViewBlack.setOnClickListener {
            binding.scrollView.smoothScrollTo(0, 1500)
        }



    }

    override fun onStop() {
        super.onStop()
        thread.interrupt()
    }

    //페이지 변경하기
    private fun setPage(){
        if(currentPosition==3) currentPosition=0
        binding.homeImageSlider.setCurrentItem(currentPosition, true)
        currentPosition+=1
    }

    //2초 마다 페이지 넘기기
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
            mDelayHandler.postDelayed(::showImg1, 5000)// 5초 후에 showGuest 함수를 실행한다.
        }else if (img==2){
            mDelayHandler.postDelayed(::showImg2, 5000)
        }else if (img==4000){
            //다른프레그넌트 일때 에러남
        }
    }

    private fun showImg1(){
        // 실제 반복하는 코드를 여기에 적는다
        img=2
        binding.homeImageview.setImageResource(R.drawable.home_page2)
        waitGuest() // 코드 실행뒤에 계속해서 반복하도록 작업한다.
    }
    private fun showImg2(){
        // 실제 반복하는 코드를 여기에 적는다
        img=1
        binding.homeImageview.setImageResource(R.drawable.home_page1)
        waitGuest() // 코드 실행뒤에 계속해서 반복하도록 작업한다.
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }*/
}