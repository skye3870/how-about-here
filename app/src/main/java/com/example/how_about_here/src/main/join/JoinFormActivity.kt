package com.example.how_about_here.src.main.join

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivityTest
import com.example.how_about_here.databinding.ActivityJoinFormBinding
import com.example.how_about_here.src.main.join.models.SignUpResponse
import com.example.how_about_here.src.main.join.models.UserResponse


class JoinFormActivity : BaseActivityTest<ActivityJoinFormBinding>(ActivityJoinFormBinding::bind, R.layout.activity_join_form),
    JoinFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            //showLoadingDialog(this)
            JoinService(this).tryGetUsers()
        binding.textViewEmailWarning.setText("이메일 주소를 확인해 주세요.")

        /*binding.homeBtnTryPostHttpMethod.setOnClickListener {
            val email = binding.homeEtId.text.toString()
            val password = binding.homeEtPw.text.toString()
            val postRequest = PostSignUpRequest(email = email, password = password,
                confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
            showLoadingDialog(context!!)
            HomeService(this).tryPostSignUp(postRequest)
        }*/

        binding.agree.setOnClickListener() {
            val intent = Intent(context, JoinSuccessActivity::class.java)
            startActivity(intent)

        }
    }








    override fun onGetUserSuccess(response: UserResponse) {
        dismissLoadingDialog()
        for (User in response.result) {
            Log.d("HomeFragment", User.toString())
        }
        //binding.homeButtonTryGetJwt.text = response.message
        showCustomToast("Get JWT 성공")
    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        binding.textViewEmailWarning.text = response.message
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

}