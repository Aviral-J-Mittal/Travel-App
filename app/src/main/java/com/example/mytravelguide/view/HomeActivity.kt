package com.example.mytravelguide.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelguide.R
import com.example.mytravelguide.adapters.HomeRecyclerAdapter
import com.example.mytravelguide.adapters.HomeScreenAdapter
import com.example.mytravelguide.databinding.ActivityHomeBinding
import com.example.mytravelguide.databinding.NavHeaderBinding
import com.example.mytravelguide.navigator.ItemClicked
import com.example.mytravelguide.viewmodel.HomeViewModel
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.SliderAnimations

class HomeActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener,ItemClicked{
    var mActivityHomeBinding: ActivityHomeBinding?=null
    var mNavHeaderBinding:NavHeaderBinding?=null
    private var mHomeViewModel:HomeViewModel?=null
    var coming:Boolean=true
    private lateinit var toggle:ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityHomeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home)
        setSupportActionBar(mActivityHomeBinding!!.barTool)
        mNavHeaderBinding= NavHeaderBinding.inflate(layoutInflater)
        mHomeViewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(HomeViewModel::class.java)
        mActivityHomeBinding!!.navView.setNavigationItemSelectedListener(this)
        toggle=ActionBarDrawerToggle(this,mActivityHomeBinding!!.drawerLayout,mActivityHomeBinding!!.barTool,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        mActivityHomeBinding!!.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        val adapter=HomeScreenAdapter(mHomeViewModel!!.fetchData())
        mActivityHomeBinding!!.slider.setSliderAdapter(adapter)
        mActivityHomeBinding!!.slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        mActivityHomeBinding!!.slider.isAutoCycle=true
        mActivityHomeBinding!!.slider.startAutoCycle()
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mActivityHomeBinding!!.recycler.layoutManager=layoutManager
        mActivityHomeBinding!!.recycler.adapter=HomeRecyclerAdapter(mHomeViewModel!!.loadData(),this)

    }

    override fun onBackPressed() {
        if(mActivityHomeBinding!!.drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mActivityHomeBinding!!.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.log_out -> {
                val editor:SharedPreferences.Editor=getSharedPreferences("login",0).edit()
                editor.clear()
                editor.apply()
                mHomeViewModel!!.logOutIntpo()
                mHomeViewModel!!.currentInte.observe(this, Observer {  newCurrentInte ->
                    if(newCurrentInte==2 && coming) {
                        coming=false
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                        mHomeViewModel!!.currentInte.value=3
                    }
                })


            }
        }
        return true
    }

    override fun onItemClicked(curPos:Int) {
        if (curPos==0)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Jaipur")
            startActivity(i1)

        }
        else if(curPos==1)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Varanasi")
            startActivity(i1)
        }
        else if(curPos==2)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Udaipur")
            startActivity(i1)
        }
        else if(curPos==3)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Bangalore")
            startActivity(i1)
        }
        else if(curPos==4)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Delhi")
            startActivity(i1)
        }
        else if(curPos==5)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Chennai")
            startActivity(i1)
        }
        else if(curPos==6)
        {
            val i1=Intent(this,PlaceActivity::class.java)
            i1.putExtra("place","Mysore")
            startActivity(i1)
        }
        else
        {
            val i1=Intent(this,TravelMapActivity::class.java)
            i1.putExtra("place","Mumbai")
            startActivity(i1)
        }
    }

}