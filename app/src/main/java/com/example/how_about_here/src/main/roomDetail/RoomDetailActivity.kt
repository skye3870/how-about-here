package com.example.how_about_here.src.main.roomDetail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityRoomDetailBinding
import com.example.how_about_here.src.main.SuccessReservationActivity
import com.example.how_about_here.src.main.roomDetail.modelReservationResult.ReservationResultRequest
import com.example.how_about_here.src.main.roomDetail.modelReservationResult.ReservationResultResponse
import com.example.how_about_here.src.main.roomDetail.modelRoomDetail.RoomDetailResponse
import com.example.how_about_here.src.main.roomDetail.modelRoomDetail.refundInfoListAdapter
import com.example.how_about_here.src.main.roomDetail.modelRoomDetail.roomInfoListAdapter


class RoomDetailActivity: BaseActivity<ActivityRoomDetailBinding>(ActivityRoomDetailBinding::inflate),
    RoomDetailActivitytView {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = ApplicationClass.sSharedPreferences.getString("id","id").toString().toInt()
        val idx = intent.getStringExtra("idx").toString().toInt()


        //val getRequest = GetRoomDetailRequest(id=id,idx=idx)
        //RoomDetailService(this).tryGetRoomDetail(GetRoomDetailRequest(id=id,idx=idx))

        RoomDetailService(this).tryGetRoomDetail(id=id,idx=idx)
        showLoadingDialog(this)

        binding.btnReserve.setOnClickListener(){
            val email=ApplicationClass.sSharedPreferences.getString("email","email").toString()

            val check_in="2022-01-01"
            val check_out="2022-01-02"
            //val date1 = LocalDate.parse(check_in, DateTimeFormatter.ISO_DATE)
            //val date2 = LocalDate.parse(check_out, DateTimeFormatter.ISO_DATE)

            RoomDetailService(this).tryPostReservation(id =id, idx =idx, check_in = check_in, check_out = check_out, ReservationResultRequest(reserveName = email,phoneNumber = "01000000000"))
            showLoadingDialog(this)
        }
    }

    override fun onSuccess(response: RoomDetailResponse) {
        dismissLoadingDialog()

            val result = response.result[0]
            //메인 사진
            Glide.with(binding.imgRoom).load(result.image[0]).into(binding.imgRoom)

           //숙소정보
            binding.cancelAvail.text = result.extraInfo
            binding.priceRoom.text = result.price.toString()
            binding.nameRoom.text = result.name
            binding.facilityDetail.text= result.facility


           //기본정보
            var roomInfoList: List<String>? = result.roomInfo
            binding.rvInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvInfo.setHasFixedSize(true)
            binding.rvInfo.adapter = roomInfoList?.let { roomInfoListAdapter(it) }


            //환불규정
            var refundInfoList: List<String>? = result.refundInfo
            binding.rvCancel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvCancel.setHasFixedSize(true)
            binding.rvCancel.adapter = refundInfoList?.let { refundInfoListAdapter(it) }



    }

    override fun onSuccessResult(response: ReservationResultResponse) {
        dismissLoadingDialog()
        val intent = Intent(this, SuccessReservationActivity::class.java)
        intent.putExtra("result", response.message)

        ContextCompat.startActivity(this, intent, null)

    }

    override fun onFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }


}