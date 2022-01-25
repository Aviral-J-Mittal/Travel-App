package com.example.mytravelguide.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mytravelguide.databinding.CardrecBinding
import com.example.mytravelguide.model.HomeCard
import com.smarteist.autoimageslider.SliderViewAdapter

class HomeScreenAdapter(private val items:ArrayList<HomeCard>) : SliderViewAdapter<HomeScreenAdapter.HomeViewHolder>() {
    override fun getCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): HomeScreenAdapter.HomeViewHolder {
        return HomeViewHolder(CardrecBinding.inflate(LayoutInflater.from(parent?.context),parent,false))
    }


    override fun onBindViewHolder(viewHolder: HomeScreenAdapter.HomeViewHolder?, position: Int) {

            val currentItem = items[position]
            viewHolder?.mCardrecBinding?.cardImg?.setImageResource(currentItem.image)
            viewHolder?.mCardrecBinding?.cardText?.text = currentItem.des


    }

    inner class HomeViewHolder(val mCardrecBinding: CardrecBinding) :
        SliderViewAdapter.ViewHolder(mCardrecBinding.root)
}
