package com.example.how_about_here.src.main.hotel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.how_about_here.R
import com.makeramen.roundedimageview.RoundedImageView


//val name: String, val cate: String, val price: Int, val content: String

class hotelViewpagerAdapter(val context: Context?):RecyclerView.Adapter<hotelViewpagerAdapter.MyViewHolder>(){


    lateinit var list:List<Int>
    fun setContentList(list:List<Int>){
        this.list=list

        notifyDataSetChanged()
    }
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var image=itemView.findViewById<RoundedImageView>(R.id.hotel_viewpager_list_item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hotelViewpagerAdapter.MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.hotel_viewpager_list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: hotelViewpagerAdapter.MyViewHolder, position: Int) {
        holder.image.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}