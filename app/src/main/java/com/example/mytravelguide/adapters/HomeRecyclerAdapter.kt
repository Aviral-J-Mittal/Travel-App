package com.example.mytravelguide.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelguide.databinding.HomeItemBinding
import com.example.mytravelguide.model.HomeCard
import com.example.mytravelguide.navigator.ItemClicked

class HomeRecyclerAdapter(private val items:ArrayList<HomeCard>,private val listener: ItemClicked) : RecyclerView.Adapter<HomeRecyclerAdapter.RecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        return RecyclerViewHolder(HomeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = items[position]
        holder.mHomeItemBinding.imgPlace.setImageResource(currentItem.image)
        holder.mHomeItemBinding.imgText.text = currentItem.des
        holder.mHomeItemBinding.imgPlace.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class RecyclerViewHolder(val mHomeItemBinding:HomeItemBinding):RecyclerView.ViewHolder(mHomeItemBinding.root)


}
