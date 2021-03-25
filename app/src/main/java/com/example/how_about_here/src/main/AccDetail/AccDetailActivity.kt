package com.example.how_about_here.src.main.AccDetail

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityAccDetailBinding
import com.example.how_about_here.src.main.AccDetail.model.*
import com.example.how_about_here.src.main.AccDetail.model.AccDetailAdapter
import com.example.how_about_here.src.main.AccDetail.model.AccFacilityAdapter


class AccDetailActivity: BaseActivity<ActivityAccDetailBinding>(ActivityAccDetailBinding::inflate),AccDetailActivitytView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("id").toString().toInt()
        //showLoadingDialog(this)
        //val getRequest = GetAccDetailRequest(id=id)


        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString("id", id.toString())
        editor.apply()
        editor.commit()


        AccDetailService(this).tryGetAccDetail(id)
    }

    override fun onSuccess(response: AccDetailResponse) {

        if(response.message.contains("완료")) {
            Log.d("1111111111111111111","3333")
            val result = response.result
            Log.d("1111111111111111111", result.toString())

            //메인 사진
            Glide.with(this).load(result.image[0].image).into(binding.accImg)

          //숙소정보
            binding.accName.text = result.name.acmdName
            binding.accWhere.text = result.address.address
            binding.accStarScore.text = result.rating.avgRRating.toString()
            binding.accShowReview.text = "리뷰" + result.reviewCount.cOUNTRReviewIdx + "개보기 >"



            binding.textList.text = result.information[0].acmdIntro
            //binding.roomExtraInfo.rvInfo.text = result.information[0].acmdInfo


            //편의시설
            var FacilityList: List<Facility>? = result.facility
            binding.roomFacility.rvFacility.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.roomFacility.rvFacility.setHasFixedSize(true)
            binding.roomFacility.rvFacility.adapter = FacilityList?.let { AccFacilityAdapter(it) }


           //룸 리스트
           var RoomList: List<Room>? = result.room
           binding.roomActivity.rvRoom.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
           binding.roomActivity.rvRoom.setHasFixedSize(true)
           binding.roomActivity.rvRoom.adapter = RoomList?.let { AccDetailAdapter(it) }



           //공지사항
            /*"Checkingformation": [
            "-최대인원 초과시 입실 불가합니다",
            "-체크인 시 보증금 요구할 수 있고,퇴실 시 전핵 환불됩니다"
            ]*/
            //var Checkingformation:List<String> = result.information

            //Log.d("ddddddddddddddddd",Checkingformation.toString())
            /*binding.roomExtraInfo.rvInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.roomExtraInfo.rvInfo.setHasFixedSize(true)
            binding.roomExtraInfo.rvInfo.adapter = CheckingformationList?.let { AccCheckingformationListAdapter(it) }*/
           //기본정보

           binding.roomExtraInfo.rvInfo.text = result.information[0].accommodationformation.toString()
           //환불규정
           binding.roomExtraInfo.rvCancel.text =result.information[0].refundInformation.toString()


       }

   }

   override fun onFailure(message: String) {
       //dismissLoadingDialog()
       showCustomToast("오류 : $message")
   }
}