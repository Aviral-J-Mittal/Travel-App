package com.example.mytravelguide.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mytravelguide.R
import com.example.mytravelguide.databinding.ActivityAccountBinding
import com.example.mytravelguide.viewmodel.AccountViewModel
import com.google.android.material.snackbar.Snackbar

 class AccountActivity : AppCompatActivity(){
    var mActivityAccountBinding:ActivityAccountBinding?=null
    var mAccountViewModel:AccountViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityAccountBinding = DataBindingUtil.setContentView(this, R.layout.activity_account)
        mAccountViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(AccountViewModel::class.java)
        mActivityAccountBinding!!.viewmodel = mAccountViewModel
        mAccountViewModel!!.error1.observe(this, Observer { newError1 ->
            if (newError1 == 1) {
                mActivityAccountBinding!!.text2.visibility = View.VISIBLE
            } else {
                mActivityAccountBinding!!.text2.visibility = View.INVISIBLE
            }

        })
        mAccountViewModel!!.error2.observe(this, Observer { newError2 ->
            if (newError2 == 1) {
                mActivityAccountBinding!!.text3.visibility = View.VISIBLE
            } else {
                mActivityAccountBinding!!.text3.visibility = View.INVISIBLE
            }
        })
        mAccountViewModel!!.passCheck3.observe(this, Observer { newPassCheck3 ->
            if (newPassCheck3 == 2) {
                mActivityAccountBinding!!.card1.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.green
                    )
                )
            } else {
                mActivityAccountBinding!!.card1.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
            }
        })
        mAccountViewModel!!.passCheck1.observe(this, Observer { newPassCheck1 ->
            if (newPassCheck1 == 2) {
                mActivityAccountBinding!!.card2.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.green
                    )
                )
            } else {
                mActivityAccountBinding!!.card2.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
            }
        })
        mAccountViewModel!!.passCheck4.observe(this, Observer { newPassCheck4 ->
            if (newPassCheck4 == 2) {
                mActivityAccountBinding!!.card3.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.green
                    )
                )
            } else {
                mActivityAccountBinding!!.card3.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
            }
        })
        mAccountViewModel!!.passCheck2.observe(this, Observer { newPassCheck2 ->
            if (newPassCheck2 == 2) {
                mActivityAccountBinding!!.card4.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.green
                    )
                )
            } else {
                mActivityAccountBinding!!.card4.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
            }
        })
        mAccountViewModel!!.moveLogin.observe(this, Observer { newMoveLogin ->
            if (newMoveLogin==2)
            {
                mAccountViewModel!!.moveLogin.value=4
                Snackbar.make(mActivityAccountBinding!!.con,"Account Created",Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(
                    applicationContext,
                    R.color.black)).setTextColor(ContextCompat.getColor(
                    applicationContext,
                    R.color.white)).show()
            }
            else if(newMoveLogin==1)
            {
                mAccountViewModel!!.moveLogin.value=4
                Toast.makeText(this, "Password conditions not met", Toast.LENGTH_LONG).show()

            }
            else if(newMoveLogin==3)
            {
                mAccountViewModel!!.moveLogin.value=4
                Toast.makeText(this, "Oops! This Gmail Id is already registered", Toast.LENGTH_LONG).show()
            }
        })
        }
 }
/*<fragment
android:layout_width="match_parent"
android:layout_height="match_parent"
android:name="com.google.android.gms.maps.SupportMapFragment"
android:id="@+id/mapTravel"/>*/