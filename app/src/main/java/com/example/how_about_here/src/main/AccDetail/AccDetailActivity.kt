package com.example.how_about_here.src.main.AccDetail

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityAccDetailBinding
import com.example.how_about_here.src.main.AccDetail.modelAccDetail.*
import com.example.how_about_here.src.main.AccDetail.modelAccDetail.AccDetailAdapter
import com.example.how_about_here.src.main.AccDetail.modelAccDetail.AccFacilityAdapter
import com.example.how_about_here.src.main.AccDetail.modelReviews.AccReviewsResponse
import com.example.how_about_here.src.main.AccDetail.modelReviews.Review


class AccDetailActivity: BaseActivity<ActivityAccDetailBinding>(ActivityAccDetailBinding::inflate),AccDetailActivitytView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("id").toString().toInt()
        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString("id", id.toString())
        editor.apply()
        editor.commit()
        showLoadingDialog(this)

        //val getRequest = GetAccDetailRequest(id=id)

        AccDetailService(this).tryGetAccDetail(id)
        AccDetailService(this).tryGetAccReviews(id)
    }

    override fun onSuccess(response: AccDetailResponse) {
        dismissLoadingDialog()
       // if (response.message.contains("완료")) {
            val result = response.result

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

            var CheckingformationList: List<String>? = result.information[0].checkingformation
            binding.roomExtraInfo.rvNoti.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.roomExtraInfo.rvNoti.setHasFixedSize(true)
            binding.roomExtraInfo.rvNoti.adapter = CheckingformationList?.let { AccCheckingformationListAdapter(it) }

            //기본정보

            var AccommodationformationList: List<String>? = result.information[0].accommodationformation
            binding.roomExtraInfo.rvInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.roomExtraInfo.rvInfo.setHasFixedSize(true)
            binding.roomExtraInfo.rvInfo.adapter = AccommodationformationList?.let { AccAccommodationformationListAdapter(it) }


            //환불규정
            var RefundInformationList: List<String>? = result.information[0].refundInformation
            binding.roomExtraInfo.rvCancel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.roomExtraInfo.rvCancel.setHasFixedSize(true)
            binding.roomExtraInfo.rvCancel.adapter = RefundInformationList?.let { AccRefundInformationListAdapter(it) }


       // }
    }
        override fun onSuccessReview(response: AccReviewsResponse) {

            val result = response.result
            //리뷰정보
            binding.reviewLayout.starScore.text = result.reviewInfo[0].average.toString()
            binding.reviewLayout.reviewCount.text=result.reviewInfo[0].counting.toString()

            //리뷰s
            var ReviewList: List<Review>? = result.review
            
            binding.reviewLayout.rvReview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.reviewLayout.rvReview.setHasFixedSize(true)
            binding.reviewLayout.rvReview.adapter = ReviewList?.let { AccReviewListListAdapter(it) }


        }



   override fun onFailure(message: String) {
       dismissLoadingDialog()
       showCustomToast("오류 : $message")
   }
}