package com.example.how_about_here.src.main.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import com.example.how_about_here.databinding.ActivityLoginEmailBinding
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.src.main.joinForm.models.UserResponse
import com.example.how_about_here.src.main.login.models.PostUserLoginRequest
import com.example.how_about_here.src.main.login.models.UsersLoginResponse


class LoginEmailActivity : BaseActivity<ActivityLoginEmailBinding>(ActivityLoginEmailBinding::inflate),LoginFragmentView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var email_bool=false
        binding.login.setOnClickListener(){

            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val getRequest = PostUserLoginRequest(email = email, password = password)

            showLoadingDialog(this)

            LoginService(this).tryUserLogin(getRequest)
            //finish()
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
    }

    override fun onGetUserLoginFailure(message: String) {

    }

    override fun onGetUserSuccess(response: UserResponse) {

    }

    override fun onGetUserFailure(message: String) {

    }

    override fun onGetUserLoginSuccess(response: UsersLoginResponse) {

    }
    fun CharSequence?.isValidEmail():Boolean{
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}