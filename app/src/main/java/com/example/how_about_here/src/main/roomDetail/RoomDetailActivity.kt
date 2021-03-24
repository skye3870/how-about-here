package com.example.how_about_here.src.main.roomDetail

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityAccDetailBinding
import com.example.how_about_here.databinding.ActivityRoomDetailBinding
import com.example.how_about_here.src.main.AccDetail.AccDetailActivitytView
import com.example.how_about_here.src.main.AccDetail.model.*
import com.example.how_about_here.src.main.roomDetail.model.RoomDetailResponse


class RoomDetailActivity: BaseActivity<ActivityRoomDetailBinding>(ActivityRoomDetailBinding::inflate),
    RoomDetailActivitytView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("idx").toString().toInt()
        //showLoadingDialog(this)
        /*RoomDetailService(this).tryGetRoomDetail(id)*/
    }

    override fun onSuccess(response: RoomDetailResponse) {

        if(response.message.contains("완료")) {

           /* val result = response.result

            //메인 사진
            Glide.with(this).load(result.image[0].image).into(binding.accImg)

            //숙소정보
            binding.accName.text = result.name.acmdName
            binding.accWhere.text = result.address.address
            binding.accStarScore.text = result.rating.avgRRating.toString()
            binding.accShowReview.text = "리뷰" + result.reviewCount.cOUNTRReviewIdx + "개보기 >"

            //Log.d("dddddddddddddd",result.image[0].image)

            binding.roomInfo.text = result.information[0].acmdIntro
            binding.roomExtraInfo.rvInfo.text = result.information[0].acmdInfo


            //룸 리스트
            var RoomList: List<Room>? = result.room
            binding.roomActivity.rvRoom.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.roomActivity.rvRoom.setHasFixedSize(true)
            binding.roomActivity.rvRoom.adapter = RoomList?.let { AccDetailAdapter(it) }


            //편의시설
            var FacilityList: List<Facility>? = result.facility
            binding.roomFacility.rvFacility.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.roomFacility.rvFacility.setHasFixedSize(true)
            binding.roomFacility.rvFacility.adapter = FacilityList?.let { AccFacilityAdapter(it) }
            //공지사항

            //기본정보
            binding.roomInfo.text = result.information[0].acmdIntro
            binding.roomExtraInfo.rvInfo.text = result.information[0].acmdInfo
            //환불규정
            binding.roomExtraInfo.rvCancel.text =result.refundInfo.refundInfo
*/

        }

    }

    override fun onFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}