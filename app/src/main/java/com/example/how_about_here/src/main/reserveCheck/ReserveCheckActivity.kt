package com.example.how_about_here.src.main.reserveCheck

import android.os.Bundle
import android.util.Log
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityReserveCheckBeforeBinding
import com.example.how_about_here.src.main.reserveCheck.model.ReserveCheckResponse
import com.example.how_about_here.src.main.reserveCheck.model.Result

class ReserveCheckActivity : BaseActivity<ActivityReserveCheckBeforeBinding>(ActivityReserveCheckBeforeBinding::inflate),
ReserveCheckActivitytView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReserveCheckService(this).tryGetReserveCheck()

        showLoadingDialog(this)
    }

    override fun onSuccess(response: ReserveCheckResponse) {
        dismissLoadingDialog()
        var reserveCheckList: List<Result>? = response.result
        lateinit var adapter: ReserveViewpagerAdapter
        adapter= reserveCheckList?.let { ReserveViewpagerAdapter(it) }!!
        binding.reserveViewpager.adapter=adapter

    }

    override fun onFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}

