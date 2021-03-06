package com.example.how_about_here.src.main.roomDetail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityRoomDetailBinding
import com.example.how_about_here.src.main.resultReservation.ResultReservationActivity
import com.example.how_about_here.src.main.resultReservation.modelReservationResult.ReservationResultRequest
import com.example.how_about_here.src.main.resultReservation.modelReservationResult.ReservationResultResponse
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

        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString("idx", idx.toString())
        editor.apply()
        editor.commit()
        showLoadingDialog(this)


        //val getRequest = GetRoomDetailRequest(id=id,idx=idx)
        //RoomDetailService(this).tryGetRoomDetail(GetRoomDetailRequest(id=id,idx=idx))

        RoomDetailService(this).tryGetRoomDetail(id=id,idx=idx)


        binding.btnReserve.setOnClickListener(){
            val email=ApplicationClass.sSharedPreferences.getString("email","email").toString()

            val check_in="2022-01-01"
            val check_out="2022-01-02"
            //val date1 = LocalDate.parse(check_in, DateTimeFormatter.ISO_DATE)
            //val date2 = LocalDate.parse(check_out, DateTimeFormatter.ISO_DATE)
            val XACCESSTOKEN : String? =ApplicationClass.X_ACCESS_TOKEN.toString()
            if (XACCESSTOKEN != null) {
                Log.d("XACCESSTOKEN",XACCESSTOKEN)
            }
            RoomDetailService(this).tryPostReservation(id =id, idx =idx, check_in = check_in, check_out = check_out,
                    ReservationResultRequest(reserveName = email,phoneNumber = "01000000000"))//,XACCESSTOKEN)

            showLoadingDialog(this)
            finish()

            /*val intent = Intent(this, ResultReservationActivity::class.java)
            intent.putExtra("result",)
            startActivity(intent,null)*/

        }

    }

    override fun onSuccess(response: RoomDetailResponse) {
        dismissLoadingDialog()

            val result = response.result[0]
            //?????? ??????
            Glide.with(binding.imgRoom).load(result.image[0]).into(binding.imgRoom)

           //????????????
            binding.cancelAvail.text = result.extraInfo
            binding.priceRoom.text = result.price.toString()
            binding.nameRoom.text = result.name
            binding.facilityDetail.text= result.facility


           //????????????
            var roomInfoList: List<String>? = result.roomInfo
            binding.rvInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvInfo.setHasFixedSize(true)
            binding.rvInfo.adapter = roomInfoList?.let { roomInfoListAdapter(it) }


            //????????????
            var refundInfoList: List<String>? = result.refundInfo
            binding.rvCancel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvCancel.setHasFixedSize(true)
            binding.rvCancel.adapter = refundInfoList?.let { refundInfoListAdapter(it) }




    }

    override fun onSuccessResult(response: ReservationResultResponse) {
        dismissLoadingDialog()
        if(response.message.contains("??????",true)){
            val intent = Intent(this, ResultReservationActivity::class.java)
            intent.putExtra("result",response.message)
            startActivity(intent,null)
        }else{
            showCustomToast(response.message)
        }
    }


    override fun onFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("?????? : $message")
    }


}