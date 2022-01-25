package com.example.mytravelguide.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel(application: Application) : AndroidViewModel(application)
{
    var handler:Handler?=null
    var pos=MutableLiveData<Int>()


    init {
        handler = Handler(Looper.getMainLooper())
    }
    var share:SharedPreferences=application.getSharedPreferences("login",0)
    var found:Boolean=share.getBoolean("hasLoggedIn",false)
    fun moveToHome()
    {
        if (found)
        {
            splash1()
        }
        else
        {
            splash()
        }
    }
    private val mRunnable:Runnable= Runnable {
       pos.value=1

    }
    private val homeRun:Runnable= Runnable {
        pos.value=2
    }
   private fun splash()
   {
           handler?.postDelayed(mRunnable,2000)

   }
     private fun splash1()
    {
        handler!!.postDelayed(homeRun,2000)
    }


}

