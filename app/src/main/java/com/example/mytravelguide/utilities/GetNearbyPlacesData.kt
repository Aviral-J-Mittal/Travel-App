package com.example.mytravelguide.utilities

import android.os.AsyncTask
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.xml.sax.XMLReader
import java.lang.Exception
import java.net.DatagramPacket


class GetNearbyPlacesData :AsyncTask<Any,String,String>()
{
    private lateinit var googlePlacesData: String
    private lateinit var mMap:GoogleMap
    private lateinit var url:String
    override fun doInBackground(vararg p0: Any?): String {
        try {
            Log.d("GetNearbyPlacesData", "doInBackground entered")
            mMap = p0[0] as GoogleMap
            url = p0[1] as String
            val downloadUrl = DownloadUrl()
            googlePlacesData = downloadUrl.readUrl(url)
            Log.d("GooglePlacesReadTask", "doInBackground Exit")
        } catch (e: Exception) {
            Log.d("GooglePlacesReadTask", e.toString())
        }
        return googlePlacesData
    }
     override fun onPostExecute(result: String) {
        Log.d("GooglePlacesReadTask", "onPostExecute Entered")
        val nearbyPlacesList: List<HashMap<String, String>>?
        val dataParser=DataParser()
        nearbyPlacesList=dataParser.pars
        showNearbyPlaces(nearbyPlacesList)
        Log.d("GooglePlacesReadTask", "onPostExecute Exit")
    }
    private fun showNearbyPlaces(nearbyPlacesList:List<HashMap<String, String>>)
    {
        for (i in 0..nearbyPlacesList.size) {
        Log.d("onPostExecute","Entered into showing locations")
        val markerOptions = MarkerOptions()
         val googlePlace:HashMap<String, String> = nearbyPlacesList[i]
        val lat = googlePlace["lat"]?.toDouble()
            val lng = googlePlace["lng"]?.toDouble()
        val placeName = googlePlace["place_name"]
        val vicinity = googlePlace["vicinity"]
        val latLng = LatLng(lat!!, lng!!)
        markerOptions.position(latLng)
        markerOptions.title("$placeName : $vicinity")
        mMap.addMarker(markerOptions)
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11f))
    }
    }
}