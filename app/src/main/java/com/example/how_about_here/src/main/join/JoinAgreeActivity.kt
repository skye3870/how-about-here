package com.example.how_about_here.src.main.join

import android.content.Intent
import android.os.Bundle
import com.example.how_about_here.config.BaseActivity
import com.example.how_about_here.databinding.ActivityJoinAgreeBinding


class JoinAgreeActivity : BaseActivity<ActivityJoinAgreeBinding>(ActivityJoinAgreeBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var checkbox1=0
        var checkbox2=0
        var checkbox3=0
        var checkbox4=0
        var checkbox5=0
        var checkbox6=0
        var checkbox7=0

        binding.agree.setOnClickListener {
            if(checkbox2==1&&checkbox3==1&&checkbox4==1) {
                val intent = Intent(this, JoinFormActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


        binding.checkbox1.setOnClickListener {
            if(checkbox1==0){
                checkbox1=1
                binding.checkbox2.isChecked=true
                binding.checkbox3.isChecked=true
                binding.checkbox4.isChecked=true
                binding.checkbox5.isChecked=true
                binding.checkbox6.isChecked=true
                binding.checkbox7.isChecked=true
                checkbox2=1
                checkbox3=1
                checkbox4=1

            }else{
                checkbox1=0
                binding.checkbox2.isChecked=false
                binding.checkbox3.isChecked=false
                binding.checkbox4.isChecked=false
                binding.checkbox5.isChecked=false
                binding.checkbox6.isChecked=false
                binding.checkbox7.isChecked=false
                checkbox2=0
                checkbox3=0
                checkbox4=0
            }
        }

        binding.checkbox2.setOnClickListener(){
            if(checkbox2==0){
                checkbox2=1
            }else{
                checkbox2=0
            }
        }
        binding.checkbox3.setOnClickListener(){
            if(checkbox3==0){
                checkbox3=1
            }else{
                checkbox3=0
            }
        }
        binding.checkbox4.setOnClickListener(){
            if(checkbox4==0){
                checkbox4=1
            }else{
                checkbox4=0
            }
        }


    }


}