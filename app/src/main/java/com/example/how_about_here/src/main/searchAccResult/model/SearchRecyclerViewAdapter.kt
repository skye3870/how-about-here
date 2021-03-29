package com.softsquared.template.kotlin.src.main.search.recyclerview

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.how_about_here.R
import com.example.how_about_here.src.main.AccDetail.AccDetailActivity
import com.example.how_about_here.src.main.searchAccResult.model.Result


class SearchAdapter(private val SearchList: List<Result>) : RecyclerView.Adapter<SearchAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val img = itemView.findViewById<ImageView>(R.id.search_seoul_hotel_img) // 호텔 이미지
        val name = itemView.findViewById<TextView>(R.id.search_seoul_hotel_name) // 호텔 이름
        val surround = itemView.findViewById<TextView>(R.id.search_seoul_hotel_location) // 호텔 주변
        val price = itemView.findViewById<TextView>(R.id.search_seoul_hotel_price) // 호텔 가격
        val reviewCnt = itemView.findViewById<TextView>(R.id.search_seoul_hotel_review_num) // 리뷰 개수
        val reviewAverage = itemView.findViewById<TextView>(R.id.search_seoul_hotel_rating) // 평점
        val rating = itemView.findViewById<TextView>(R.id.search_seoul_hotel_class) // 클래스(5성급)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_search_list_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide.with(holder.img).load(SearchList.get(position).mainImage).into(holder.img) // 호텔 이미지
        holder.name.text = SearchList.get(position).acmdName // 호텔 이름
        holder.surround.text = SearchList.get(position).nearInfo // 호텔 주변

        holder.reviewCnt.text = "(" + SearchList.get(position).cnt.toString() + ")" // 리뷰 개수
        holder.reviewAverage.text = SearchList.get(position).rating.toString() // 평점
        //rating 잘나옴? array index가져오는거 잘 모르겠음
//        holder.rating.text = SearchList.get(position).rating // 클래스(5성급)


        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, AccDetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)

        }
    }

    override fun getItemCount(): Int {
        return SearchList.size
    }

}