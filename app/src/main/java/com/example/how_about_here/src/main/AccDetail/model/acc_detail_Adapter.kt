package com.example.how_about_here.src.main.AccDetail.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.how_about_here.R
import com.example.how_about_here.src.main.AccDetail.AccDetailActivity
import com.example.how_about_here.src.main.AccDetail.model.Facility
import com.example.how_about_here.src.main.AccDetail.model.Room


//val name: String, val cate: String, val price: Int, val content: String

class AccDetailAdapter(private val RoomList: List<Room>) :RecyclerView.Adapter<AccDetailAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.acc_detail_list_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
               .apply {


            /*itemView.setOnClickListener {

                val curPos :Int =adapterPosition
                val goods:Goods=goodsList.get(curPos)
                Toast.makeText(parent.context,"${goods.name}",Toast.LENGTH_SHORT).show()

            }*/

        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {//계속실행
        //holder.image.setImageResource.(goodsList.get(position).image)

        //holder.img.setImageResource(RoomList.get(position).img as Int)
        holder.extraInfo.text=RoomList.get(position).extraInfo
        holder.price.text=RoomList.get(position).price.toString()
        //holder.roomInfo.text=RoomList.get(position).
        holder.name.text=RoomList.get(position).roomName

        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.cate.text=goodsList.get(position).cate
        holder.price.text=goodsList.get(position).price.toString()
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/
        /*holder.switch.setOnClickListener(){
            holder.switch.toggle()
            holder.switch.isChecked.toString()
            Log.d("toggle",holder.switch.toggle().toString())
            Log.d("isChecked",holder.switch.isChecked.toString())
            goodsList.set(position, Goods(
                goodsList.get(position).img,
                goodsList.get(position).name,
                goodsList.get(position).cate,
                goodsList.get(position).price,
                holder.switch.isChecked.toString().toBoolean()
                )
            )
        }*/

       holder.itemView.setOnClickListener {
           val intent = Intent(holder.itemView.context, AccDetailActivity::class.java)


       }
            //intent.putExtra("id", RoomList.get(position).id.toString())
            /*intent.putExtra("img", goodsList.get(position).img.toString())
            intent.putExtra("name", goodsList.get(position).name)
            intent.putExtra("cate", goodsList.get(position).cate)
            intent.putExtra("price", goodsList.get(position).price.toString())
            intent.putExtra("switch", goodsList.get(position).switch)*//*
            startActivity(holder.itemView.context, intent, null)
        }*/

    }

    override fun getItemCount(): Int {
        return RoomList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        //val switch = itemView.findViewById<Switch>(R.id.switch_button)
        val img = itemView.findViewById<ImageView>(R.id.img_hotel)

        val name = itemView.findViewById<TextView>(R.id.room_name)
        val price = itemView.findViewById<TextView>(R.id.room_price)
        val roomInfo =itemView.findViewById<TextView>(R.id.room_info)
        val extraInfo =itemView.findViewById<TextView>(R.id.extra_info)

    }


}

class AccFacilityAdapter(private val FacilityList: List<Facility>) :RecyclerView.Adapter<AccFacilityAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.acc_facility_list_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
            .apply {


                /*itemView.setOnClickListener {

                    val curPos :Int =adapterPosition
                    val goods:Goods=goodsList.get(curPos)
                    Toast.makeText(parent.context,"${goods.name}",Toast.LENGTH_SHORT).show()

                }*/

            }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {//계속실행
        //holder.image.setImageResource.(goodsList.get(position).image)
        /*Glide.with(this).load(result.image[0].image).into(binding.accImg)
        holder.img.setImageResource(RoomList.get(position).img as Int)*/



       Glide.with(holder.img).load(FacilityList.get(position).facilityImage).into(holder.img)
        holder.name.text=FacilityList.get(position).facilityName
      //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/

    }
    override fun getItemCount(): Int {
        return FacilityList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //val switch = itemView.findViewById<Switch>(R.id.switch_button)
        val img = itemView.findViewById<ImageView>(R.id.img_facility)
        val name = itemView.findViewById<TextView>(R.id.text_facility)
    }

}


