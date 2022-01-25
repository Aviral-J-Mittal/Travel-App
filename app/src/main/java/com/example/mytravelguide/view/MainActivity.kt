package com.example.mytravelguide.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mytravelguide.base.BaseActivity
import com.example.mytravelguide.databinding.ActivityMainBinding
import com.example.mytravelguide.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    var mActivityMainBinding:ActivityMainBinding?=null
    var mMainViewModel:MainViewModel?=null
    var coming:Boolean=true
    var incoming:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mActivityMainBinding!!.root)
        mMainViewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MainViewModel::class.java)
        mMainViewModel!!.moveToHome()
        mMainViewModel!!.pos.observe(this, Observer { newPos ->
            if(newPos==1 && coming) {

                    coming = false
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                    mMainViewModel!!.pos.value = 3
            }
            else if(newPos==2 && incoming)
            {
                incoming=false
                val intent1 = Intent(this, HomeActivity::class.java)
                startActivity(intent1)
                finish()
                mMainViewModel!!.pos.value=3
            }

        })

    }

}
