package com.example.how_about_here.src.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinLoginBinding
import com.example.how_about_here.src.main.MainActivity
import com.example.how_about_here.src.main.join.JoinAgreeActivity
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient


class JoinLoginKakaoActivity : BaseActivity<ActivityJoinLoginBinding>(ActivityJoinLoginBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            //카카오 초기화
            KakaoSdk.init(this, "7ac7170e8621f04617fcd208ce7d9eb3")
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

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

/****************************************************************************************************************/
                    //카카오 로그인 정보 받아오기
                    UserApiClient.instance.me { user, error ->
                        if (error != null) {
                            Log.d("TAG", "사용자 정보 요청 실패", error)
                        }
                        else if (user != null) {

                            Log.d("TAG", "사용자 정보 요청 성공" +
                                    "\n회원번호: ${user.id}" +
                                    "\n이메일: ${user.kakaoAccount?.email}" +
                                    "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                                    "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")
                            Toast.makeText(this, "${user.kakaoAccount?.profile?.nickname} " +
                                    "님 로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                           /* var bitmap=user.kakaoAccount?.profile?.thumbnailImageUrl
                            if (bitmap !== null) {
                                Glide.with(this)
                                    .load(bitmap)
                                    .into(binding.profile)
                            } else {
                                binding.profile.setImageResource(0)
                            }*/
                        }
                    }
                }
            }


            binding.myBtnLoginKakao.setOnClickListener {
                //if(LoginClient.instance.isKakaoTalkLoginAvailable(this)){
                //LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
                //}else{//카카오톡 설치x
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
                //}
            }
            binding.joinEmail.setOnClickListener(){
            //이메일로 가입
            val intent = Intent(this, JoinAgreeActivity::class.java)
            startActivity(intent)
            finish()
            }
        binding.myBtnLoginEmail.setOnClickListener(){
            //이메일로 로그인
            val intent = Intent(this, LoginEmailActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}