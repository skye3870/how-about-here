package com.example.how_about_here.src.main.AccDetail

import android.os.Bundle
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityAccDetailBinding
import com.example.how_about_here.src.main.AccDetail.model.AccDetailResponse
import com.example.how_about_here.src.main.AccDetail.model.GetAccDetailRequest


class AccDetailActivity: BaseActivity<ActivityAccDetailBinding>(ActivityAccDetailBinding::inflate),AccDetailActivitytView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val id = intent.getStringExtra("id")
        binding.hotelId.text = id*/

        val id = intent.getStringExtra("id").toString().toInt()
                //binding.id.text.toString().toInt()
        val getRequest = GetAccDetailRequest(id = id)

        showLoadingDialog(this)
        AccDetailService(this).tryGetAccDetail(id)


    }

    override fun onSuccess(response: AccDetailResponse) {
        //dismissLoadingDialog()
        //binding.homeBtnTryPostHttpMethod.text = response.message
        response.message.let { showCustomToast(it) }
        if(response.message.contains("완료")){
            /*val intent = Intent(this, JoinSuccessActivity::class.java)
            startActivity(intent)
            finish()*/
        }
    }

    override fun onFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}