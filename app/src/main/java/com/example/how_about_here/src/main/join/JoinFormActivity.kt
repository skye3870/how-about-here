package com.example.how_about_here.src.main.join

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.core.widget.addTextChangedListener
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinFormBinding
import com.example.how_about_here.src.main.join.models.SignUpResponse
import com.example.how_about_here.src.main.join.models.UserResponse


class JoinFormActivity : BaseActivity<ActivityJoinFormBinding>(ActivityJoinFormBinding::inflate),JoinFragmentView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.agree.setOnClickListener {
            //이메일 중복검사

            val intent = Intent(this, JoinSuccessActivity::class.java)
            startActivity(intent)
            //finish()
        }

        /*var password :String?=null
        var password_check :String?=null


        binding.editTextEmail.addTextChangedListener(object: TextWatcher {
            //이메일 유효성
            override fun beforeTextChanged(p0: CharSequence?,
                                           p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                // check inputted text that it is a valid email address or not
                if (p0.isValidEmail()){
                    binding.textViewEmailWarning.setTextColor(Color.GRAY)
                    binding.textViewEmailWarning.error = null
                    binding.textViewEmailWarning.text = "사용가능한 이메일 주소 입니다."
                }else{
                    binding.textViewEmailWarning.setTextColor(Color.RED)
                    binding.textViewEmailWarning.text = "이메일 주소를 확인해 주세요."
                    binding.textViewEmailWarning.error = "Invalid email."
                }
            }

            override fun afterTextChanged(p0: Editable?) { }
        })

        binding.editTextPassword.addTextChangedListener(object: TextWatcher {
            //비밀번호 유효성
            override fun beforeTextChanged(p0: CharSequence?,
                                           p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                var password_leng=binding.editTextPassword.length()
                password=binding.editTextPassword.text.toString()
                // check inputted text that it is a valid email address or not
                if (password_leng>=8){
                    binding.textViewPasswordWarning.setTextColor(Color.GRAY)
                    binding.textViewPasswordWarning.error = null
                    binding.textViewPasswordWarning.text = "사용가능한 비밀번호 입니다."

                }else{
                    binding.textViewPasswordWarning.setTextColor(Color.RED)
                    binding.textViewPasswordWarning.text = "사용불가 : 최고 8자 이상 입력해 주세요."
                    binding.textViewPasswordWarning.error = "Invalid email."
                }
            }
            override fun afterTextChanged(p0: Editable?) { }
        })

        binding.editTextPasswordCheck.addTextChangedListener(object: TextWatcher {
            //비밀번호 일치
            override fun beforeTextChanged(p0: CharSequence?,
                                           p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                password_check=binding.editTextPasswordCheck.text.toString()
                // check inputted text that it is a valid email address or not
                if (password.equals(password_check)){
                    binding.textViewPasswordCheckWarning.setTextColor(Color.GRAY)
                    binding.textViewPasswordCheckWarning.error = null
                    binding.textViewPasswordCheckWarning.text = "사용가능 : 처음 입력한 비밀번호와 일치합니다."
                }else{
                    binding.textViewPasswordCheckWarning.setTextColor(Color.RED)
                    binding.textViewPasswordCheckWarning.text = "사용불가 : 처음입력한 비밀번호가 아닙니다."
                    binding.textViewPasswordCheckWarning.error = "Invalid email."
                }
            }
            override fun afterTextChanged(p0: Editable?) { }
        })*/
    }



    /*fun CharSequence?.isValidEmail():Boolean{
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }*/
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
        //binding.homeBtnTryPostHttpMethod.text = response.message
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

}