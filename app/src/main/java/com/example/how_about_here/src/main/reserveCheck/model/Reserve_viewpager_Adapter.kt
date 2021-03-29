package com.example.how_about_here.src.main.reserveCheck

import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.how_about_here.R
import com.example.how_about_here.src.main.reserveCheck.model.Result
import com.example.how_about_here.src.main.roomDetail.RoomDetailActivity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


//룸 리스트
class ReserveViewpagerAdapter(private val reserveCheckList: List<Result>) :RecyclerView.Adapter<ReserveViewpagerAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_reserve_check_viewpage_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {


                    /*itemView.setOnClickListener {

                        val curPos :Int =adapterPosition
                        val goods:Goods=goodsList.get(curPos)
                        Toast.makeText(parent.context,"${goods.name}",Toast.LENGTH_SHORT).show()

                    }*/

                }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {//계속실행
        //holder.image.setImageResource.(goodsList.get(position).image)
        //holder.img.setImageResource(RoomList.get(position).img as Int)

        Glide.with(holder.img).load(reserveCheckList.get(position).image).into(holder.img)
        holder.name.text=reserveCheckList.get(position).acmdName
        holder.check_in.text=reserveCheckList.get(position).checkIn
        holder.check_out.text=reserveCheckList.get(position).checkOut
        holder.where.text=reserveCheckList.get(position).roomName



        /*val today: Int = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString().toInt()
        val thatday: Int = reserveCheckList.get(position).checkIn.format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString().toInt()

        val diff= thatday.minus(today).toString().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"))
        holder.vaild.text=diff*/


        holder.itemView.setOnClickListener {

            /*val intent = Intent(holder.itemView.context, RoomDetailActivity::class.java)
            //Log.d("ddddddddddddddddddddddd",RoomList.get(position).roomIdx.toString())

            //("id", id.toString())


            intent.putExtra("idx",RoomList.get(position).roomIdx.toString())
            ContextCompat.startActivity(holder.itemView.context, intent, null)
*/
        }



    }

    override fun getItemCount(): Int {
        return reserveCheckList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var img=itemView.findViewById<ImageView>(R.id.img)
        var name=itemView.findViewById<TextView>(R.id.reservation_check_name)
        var where =itemView.findViewById<TextView>(R.id.where)
        var check_in =itemView.findViewById<TextView>(R.id.reservation_check_check_in_date)
        var check_out =itemView.findViewById<TextView>(R.id.reservation_check_check_out_date)
        var vaild=itemView.findViewById<TextView>(R.id.reservation_check_time)
    }



}