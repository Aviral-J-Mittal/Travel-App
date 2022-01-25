package com.example.mytravelguide.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mytravelguide.R
import com.example.mytravelguide.databinding.ActivityLoginBinding
import com.example.mytravelguide.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    var mActivityLoginBinding: ActivityLoginBinding?=null
    private var mLoginViewModel:LoginViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login)
        mLoginViewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(LoginViewModel::class.java)
        mActivityLoginBinding!!.viewmodel=mLoginViewModel
        mLoginViewModel!!.error1.observe(this, Observer {  newError1 ->
            if (newError1==1)
            {
                mActivityLoginBinding!!.text2.visibility=View.VISIBLE
            }
            else
            {
                mActivityLoginBinding!!.text2.visibility=View.INVISIBLE
            }
        })
        mLoginViewModel!!.error2.observe(this, Observer {  newError2 ->
            if (newError2==1)
            {
                mActivityLoginBinding!!.text3.visibility=View.VISIBLE
            }
            else
            {
                mActivityLoginBinding!!.text3.visibility=View.INVISIBLE
            }
        })
        mLoginViewModel!!.moveHome.observe(this, Observer {  newMoveHome ->
            if(newMoveHome==1)
            {
                val intent1 = Intent(this, HomeActivity::class.java)
                startActivity(intent1)
                finish()
            }
            else{
                Toast.makeText(this,"Invalid credentials",Toast.LENGTH_LONG).show()
            }
        })
        mLoginViewModel!!.text.observe(this, Observer { newText ->
            if(newText==1) {
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
                mLoginViewModel!!.text.value=2
            }

        })
    }
}