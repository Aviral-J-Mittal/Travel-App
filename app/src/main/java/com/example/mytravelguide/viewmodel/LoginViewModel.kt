package com.example.mytravelguide.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytravelguide.data.DatabaseHelper

class LoginViewModel(application: Application) : AndroidViewModel(application) {
   val userMail = MutableLiveData<String>()
    val userPass = MutableLiveData<String>()
    var error1=MutableLiveData<Int>()
    var moveHome=MutableLiveData<Int>()
    var error2=MutableLiveData<Int>()
    var share:SharedPreferences?=null
    private var editor:SharedPreferences.Editor?=null
    var text=MutableLiveData<Int>()
    private var databaseHelp:DatabaseHelper?=null
    init {
         databaseHelp=DatabaseHelper(application)
         share=application.getSharedPreferences("login",0)
         editor=share!!.edit()


    }
    fun onLoginClicked()
    {
        when {
            userMail.value.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userMail.value.toString().trim())
                .matches() -> {
                error1.value=1
                error2.value=2
            }

            userPass.value.isNullOrEmpty() -> {
                error2.value=1
                error1.value=2
            }
            else -> {
                error1.value=2
                error2.value=2
                if (databaseHelp!!.checkUserMailPass(userMail.value.toString().trim(),userPass.value.toString()))
                {
                   moveHome.value=1
                    editor!!.putBoolean("hasLoggedIn",true).commit()
                }
                else
                {
                    moveHome.value=2
                }
            }

        }

    }
    fun onTextClicked()
    {
        text.value=1
    }
}