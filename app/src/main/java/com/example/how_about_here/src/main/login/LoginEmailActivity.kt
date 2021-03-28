package com.example.how_about_here.src.main.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.how_about_here.databinding.ActivityLoginEmailBinding
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.FragmentMyBinding
import com.example.how_about_here.src.main.MainActivity
import com.example.how_about_here.src.main.join.JoinSuccessActivity
import com.example.how_about_here.src.main.joinForm.models.UserResponse
import com.example.how_about_here.src.main.login.models.PostUserLoginRequest
import com.example.how_about_here.src.main.login.models.UsersLoginResponse


class LoginEmailActivity : BaseActivity<ActivityLoginEmailBinding>(ActivityLoginEmailBinding::inflate),LoginActivityView{
    var email=""

    override fun onCreate(savedInstanceState: Bundle?) {
        var email_bool=false

        super.onCreate(savedInstanceState)

        binding.login.setOnClickListener(){

            email = binding.editTextEmail.text.toString()
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

    override fun onGetUserLoginSuccess(response: UsersLoginResponse) {
        dismissLoadingDialog()
        //jwt
        val jwt=response.result.jwt

        val editor =ApplicationClass.sSharedPreferences.edit()
        editor.putString("email",email)
        editor.putString(X_ACCESS_TOKEN,jwt)
        X_ACCESS_TOKEN=jwt
        editor.apply()
        editor.commit()


        //binding.homeBtnTryPostHttpMethod.text = response.message
        response.message?.let { showCustomToast(it) }
        if(response.message?.contains("성공")){

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onGetUserLoginFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("로그인 실패 : $message")
    }

    fun CharSequence?.isValidEmail():Boolean{
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}