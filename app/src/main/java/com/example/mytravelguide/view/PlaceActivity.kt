package com.example.mytravelguide.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mytravelguide.R
import com.example.mytravelguide.databinding.ActivityHomeBinding
import com.example.mytravelguide.databinding.ActivityPlaceBinding
import com.example.mytravelguide.viewmodel.HomeViewModel
import com.example.mytravelguide.viewmodel.PlaceViewModel
import com.google.android.gms.maps.SupportMapFragment

class PlaceActivity : AppCompatActivity() {
    var mActivityPlaceBinding: ActivityPlaceBinding?=null
    private var mPlaceViewModel: PlaceViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityPlaceBinding= DataBindingUtil.setContentView(this,R.layout.activity_place)
        setSupportActionBar(mActivityPlaceBinding!!.toolbar)
        mPlaceViewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PlaceViewModel::class.java)
        val intent = intent
        val name = intent.getStringExtra("place")
        if(name=="Jaipur")
            {
                mActivityPlaceBinding!!.textPlace.text="JAIPUR"
            }
        else if(name=="Varanasi")
        {
            mActivityPlaceBinding!!.textPlace.text="VARANASI"
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_buttons,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id==R.id.map)
        {
        val i1= Intent(this,TravelMapActivity::class.java)
            i1.putExtra("placeMap",mActivityPlaceBinding!!.textPlace.text.toString())
            startActivity(i1)

        }
        return true
    }
}