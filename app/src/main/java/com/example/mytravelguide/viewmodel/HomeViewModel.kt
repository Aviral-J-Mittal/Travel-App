package com.example.mytravelguide.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mytravelguide.R
import com.example.mytravelguide.model.HomeCard

class HomeViewModel(application:Application):AndroidViewModel(application) {
    var currentInte=MutableLiveData<Int>()

     fun fetchData():ArrayList<HomeCard> {
        val slideData = arrayListOf<HomeCard>()
        val h1 = HomeCard(R.drawable.nanital, "Nainital")
        slideData.add(h1)
        val h2 = HomeCard(R.drawable.leh, "Ladakh")
        slideData.add(h2)
        val h3 = HomeCard(R.drawable.jaisalmer, "Jaisalmer")
        slideData.add(h3)
        val h4 = HomeCard(R.drawable.beach, "Vagator Beach")
        slideData.add(h4)
        val h5 = HomeCard(R.drawable.birds, "Dona Paula")
        slideData.add(h5)
        val h6 = HomeCard(R.drawable.shimla, "Shimla")
        slideData.add(h6)
        return slideData
    }






    fun loadData():ArrayList<HomeCard>
    {

        val recyclerData= arrayListOf<HomeCard>()
        val h1 = HomeCard(R.drawable.jaipur,"Jaipur")
        recyclerData.add(h1)
        val h2 = HomeCard(R.drawable.varanasi,"Varanasi")
        recyclerData.add(h2)
        val h3 = HomeCard(R.drawable.udaipur,"Udaipur")
        recyclerData.add(h3)
        val h4 = HomeCard(R.drawable.bangalore,"Bangalore")
        recyclerData.add(h4)
        val h5 = HomeCard(R.drawable.delhi,"Delhi")
        recyclerData.add(h5)
        val h6 = HomeCard(R.drawable.chennai,"Chennai")
        recyclerData.add(h6)
        val h7 = HomeCard(R.drawable.mysore,"Mysore")
        recyclerData.add(h7)
        val h8 = HomeCard(R.drawable.mumbai,"Mumbai")
        recyclerData.add(h8)
        return recyclerData
    }


    fun logOutIntpo()
    {
       currentInte.value=2
    }

}