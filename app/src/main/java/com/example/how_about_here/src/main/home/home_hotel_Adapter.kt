package com.example.how_about_here.src.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.how_about_here.R
import com.example.how_about_here.src.main.AccDetail.AccDetailActivity


//val name: String, val cate: String, val price: Int, val content: String

class HomeHotelAdapter(private val HomeHotelArr: ArrayList<HomeHotel>) :RecyclerView.Adapter<HomeHotelAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_hotel_resort_list_item, parent, false)//뷰를 붙여줌


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

        holder.img.setImageResource(HomeHotelArr.get(position).img as Int)
        holder.special.text=HomeHotelArr.get(position).special
        holder.name.text=HomeHotelArr.get(position).name
        holder.star.text=HomeHotelArr.get(position).star.toString()
        holder.review.text=HomeHotelArr.get(position).review.toString()
        holder.where.text=HomeHotelArr.get(position).where
        holder.price.text=HomeHotelArr.get(position).price.toString()
        holder.price_origin.text=HomeHotelArr.get(position).price_orgin.toString()



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
            intent.putExtra("id", HomeHotelArr.get(position).id.toString())
            /*intent.putExtra("img", goodsList.get(position).img.toString())
            intent.putExtra("name", goodsList.get(position).name)
            intent.putExtra("cate", goodsList.get(position).cate)
            intent.putExtra("price", goodsList.get(position).price.toString())
            intent.putExtra("switch", goodsList.get(position).switch)*/
            startActivity(holder.itemView.context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return HomeBlackArr.size
    }



    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        //val switch = itemView.findViewById<Switch>(R.id.switch_button)
        val img = itemView.findViewById<ImageView>(R.id.img_hotel)
        val special =itemView.findViewById<TextView>(R.id.text_special)
        val name = itemView.findViewById<TextView>(R.id.text_name)
        //val cate = itemView.findViewById<TextView>(R.id.cate)
        val star = itemView.findViewById<TextView>(R.id.text_star_rate)
        val review = itemView.findViewById<TextView>(R.id.text_star_review_count)
        val where = itemView.findViewById<TextView>(R.id.text_where)
        val price = itemView.findViewById<TextView>(R.id.text_price)
        val price_origin = itemView.findViewById<TextView>(R.id.text_price_origin)


    }








}

