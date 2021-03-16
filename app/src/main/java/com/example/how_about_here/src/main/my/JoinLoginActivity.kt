package com.example.how_about_here.src.main.my

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinLoginBinding
import com.example.how_about_here.databinding.ActivityMainBinding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause


class JoinLoginActivity : BaseActivity<ActivityJoinLoginBinding>(ActivityJoinLoginBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.joinEmail.setOnClickListener(){
            //이메일로 가입
            val intent = Intent(this, JoinAgreeActivity::class.java)
            startActivity(intent)
            finish()
        }


            //카카오로그인 연동
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    when {
                        error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                            Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                            Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                            Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                            Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                            Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                            Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.ServerError.toString() -> {
                            Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                            Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                        }
                        else -> { // Unknown
                            Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else if (token != null) {
                    //Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, JoinSuccessActivity::class.java)
                    startActivity(intent)
                }
            }


            binding.myBtnLoginKakao.setOnClickListener {
                //if(LoginClient.instance.isKakaoTalkLoginAvailable(this)){
                //LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
                //}else{//카카오톡 설치x
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
                //}
            }


    }


}