package com.example.how_about_here.src.main.AccDetail.model

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.how_about_here.R
import com.example.how_about_here.src.main.AccDetail.AccDetailActivity
import com.example.how_about_here.src.main.roomDetail.RoomDetailActivity


//룸 리스트
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

        holder.price.text=RoomList.get(position).price.toString()
        holder.roomInfo.text=RoomList.get(position).roomInformation
        holder.extraInfo.text=RoomList.get(position).extraInfo
        holder.name.text=RoomList.get(position).roomName

        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())


       holder.itemView.setOnClickListener {

           val intent = Intent(holder.itemView.context, RoomDetailActivity::class.java)
           Log.d("ddddddddddddddddddddddd",RoomList.get(position).roomIdx.toString())
           intent.putExtra("idx",RoomList.get(position).roomIdx.toString())
           startActivity(holder.itemView.context, intent, null)
       }


    }

    override fun getItemCount(): Int {
        return RoomList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        //val switch = itemView.findViewById<Switch>(R.id.switch_button)
        val img = itemView.findViewById<ImageView>(R.id.img_hotel)

        val name = itemView.findViewById<TextView>(R.id.room_name)
        val price = itemView.findViewById<TextView>(R.id.room_price)
        val roomInfo =itemView.findViewById<TextView>(R.id.text_list)
        val extraInfo =itemView.findViewById<TextView>(R.id.extra_info)

    }


}


//편의시설
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


//공지사항
class AccCheckingformationListAdapter(private val CheckingformationList: List<String>) :RecyclerView.Adapter<AccCheckingformationListAdapter.CustomViewHolder>(){


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




        holder.text.text=CheckingformationList.get(position).toString()
        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/

    }
    override fun getItemCount(): Int {
        return CheckingformationList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //val switch = itemView.findViewById<Switch>(R.id.switch_button)

        val text = itemView.findViewById<TextView>(R.id.text_list)
    }

}
