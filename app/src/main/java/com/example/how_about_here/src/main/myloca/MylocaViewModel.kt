package com.example.how_about_here.src.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MylocaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is myloca Fragment"
    }
    val text: LiveData<String> = _text
}