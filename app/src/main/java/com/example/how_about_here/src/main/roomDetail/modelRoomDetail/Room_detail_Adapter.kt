package com.example.how_about_here.src.main.roomDetail.modelRoomDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.how_about_here.R


//공지사항
class roomInfoListAdapter(private val RoomInfoList: List<String>) :RecyclerView.Adapter<roomInfoListAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.acc_text_list_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
            .apply {

            }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {//계속실행

        holder.text.text=RoomInfoList.get(position).toString()
        }
    override fun getItemCount(): Int {
        return RoomInfoList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val text = itemView.findViewById<TextView>(R.id.text_list)
    }

}


//기본정보
class refundInfoListAdapter(private val RefindInfoList: List<String>) :RecyclerView.Adapter<refundInfoListAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.acc_text_list_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {//계속실행
        //holder.image.setImageResource.(goodsList.get(position).image)
        /*Glide.with(this).load(result.image[0].image).into(binding.accImg)
        holder.img.setImageResource(RoomList.get(position).img as Int)*/




        holder.text.text=RefindInfoList.get(position).toString()
        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/

    }
    override fun getItemCount(): Int {
        return RefindInfoList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //val switch = itemView.findViewById<Switch>(R.id.switch_button)

        val text = itemView.findViewById<TextView>(R.id.text_list)
    }

}

