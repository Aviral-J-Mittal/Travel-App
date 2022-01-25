package com.example.mytravelguide.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.mytravelguide.BR
import com.example.mytravelguide.R
import com.example.mytravelguide.base.BaseActivity
import com.example.mytravelguide.databinding.ActivityTravelmapBinding
import com.example.mytravelguide.navigator.MapNavigator
import com.example.mytravelguide.viewmodel.TourMapViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class TravelMapActivity : BaseActivity<ActivityTravelmapBinding, TourMapViewModel>(), MapNavigator,
    OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private var binding: ActivityTravelmapBinding? = null
    private var mMapViewModel: TourMapViewModel? = null

    override fun getBindingVariable(): Int {
        return BR.mapViewmodel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_travelmap
    }

    override fun getViewModel(): TourMapViewModel {
        mMapViewModel = ViewModelProvider(this).get(TourMapViewModel::class.java)
        return mMapViewModel!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        mMapViewModel?.setNavigator(this)
        setSupportActionBar(binding?.mapToolBar)

        val mapFragment=supportFragmentManager.findFragmentById(R.id.mapTravel) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val intent=intent
        val name = intent.getStringExtra("placeMap")
        if (name=="JAIPUR") {

            val jaipur = LatLng(27.0, 76.0)
            mMap.addMarker(MarkerOptions().position(jaipur).title("Jaipur"))
           // mMap.moveCamera(CameraUpdateFactory.newLatLng(jaipur))
            val cameraUpdate=CameraUpdateFactory.newLatLngZoom(jaipur,12f)
            mMap.animateCamera(cameraUpdate)
        }
        else if(name=="VARANASI") {

             val varanasi = LatLng(25.4, 83.0)
            mMap.addMarker(MarkerOptions().position(varanasi).title("Varanasi"))
            val cameraUpdate=CameraUpdateFactory.newLatLngZoom(varanasi,12f)
            mMap.animateCamera(cameraUpdate)
        }


    }


}