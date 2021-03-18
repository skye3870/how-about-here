package com.example.how_about_here.src.main.joinForm

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinFormBinding
import com.example.how_about_here.src.main.join.JoinSuccessActivity
import com.example.how_about_here.src.main.joinForm.models.PostSignUpRequest
import com.example.how_about_here.src.main.joinForm.models.SignUpResponse
import com.example.how_about_here.src.main.joinForm.models.UserResponse


class JoinFormActivity : BaseActivity<ActivityJoinFormBinding>(ActivityJoinFormBinding::inflate),JoinFragmentView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var password :String?=null
        var password_check :String?=null
        var password_bool : Boolean =false
        var email_bool : Boolean =false

        if(password_bool && email_bool) {
            binding.agree.setCardBackgroundColor(Color.BLUE)}

        binding.agree.setOnClickListener {
            //회원정보 가져오기
            /*showLoadingDialog(this)
            JoinService(this).tryGetUsers()*/
            //api add 회원가입
            if(password_bool && email_bool) {
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()
                val nickname = binding.editTextNickName.text.toString()
                val postRequest = PostSignUpRequest(email = email, password = password,
                        confirmPassword = password, nickname = nickname, phoneNumber = "")
                showLoadingDialog(this)
                JoinService(this).tryPostSignUp(postRequest)

            }
        }




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
                    email_bool=true
                }else{
                    binding.textViewEmailWarning.setTextColor(Color.RED)
                    binding.textViewEmailWarning.text = "이메일 주소를 확인해 주세요."
                    binding.textViewEmailWarning.error = "Invalid email."
                    email_bool=false
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
                    password_bool=true

                }else{
                    binding.textViewPasswordWarning.setTextColor(Color.RED)
                    binding.textViewPasswordWarning.text = "사용불가 : 최고 8자 이상 입력해 주세요."
                    binding.textViewPasswordWarning.error = "Invalid email."
                    password_bool=false
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
        })

        binding.editTextNickName.addTextChangedListener(object: TextWatcher {
            //닉네임
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
                    password_bool=true

                }else{
                    binding.textViewPasswordWarning.setTextColor(Color.RED)
                    binding.textViewPasswordWarning.text = "사용불가 : 최고 8자 이상 입력해 주세요."
                    binding.textViewPasswordWarning.error = "Invalid email."
                    password_bool=false
                }
            }
            override fun afterTextChanged(p0: Editable?) { }
        })
    }

    fun CharSequence?.isValidEmail():Boolean{
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    override fun onGetUserSuccess(response: UserResponse) {
        dismissLoadingDialog()
        for (User in response.result) {
            Log.d("/users", User.toString())
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
        if(response.message?.contains("성공") == true){
        val intent = Intent(this, JoinSuccessActivity::class.java)
        startActivity(intent)
        finish()
        }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }



}

