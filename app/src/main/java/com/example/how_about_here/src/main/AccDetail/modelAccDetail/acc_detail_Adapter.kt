package com.example.how_about_here.src.main.AccDetail.modelAccDetail

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
import com.example.how_about_here.src.main.AccDetail.modelReviews.Review
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

        Log.d("aaaaaaaaaaaa",RoomList.get(position).extraInfo.toString())


       holder.itemView.setOnClickListener {

           val intent = Intent(holder.itemView.context, RoomDetailActivity::class.java)
           //Log.d("ddddddddddddddddddddddd",RoomList.get(position).roomIdx.toString())

           //("id", id.toString())


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
        val roomInfo =itemView.findViewById<TextView>(R.id.room_info)
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


//기본정보
class AccAccommodationformationListAdapter(private val AccommodationformationList: List<String>) :RecyclerView.Adapter<AccAccommodationformationListAdapter.CustomViewHolder>(){


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




        holder.text.text=AccommodationformationList.get(position).toString()
        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/

    }
    override fun getItemCount(): Int {
        return AccommodationformationList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //val switch = itemView.findViewById<Switch>(R.id.switch_button)

        val text = itemView.findViewById<TextView>(R.id.text_list)
    }

}


//환불규정
class AccRefundInformationListAdapter(private val RefundInformationList: List<String>) :RecyclerView.Adapter<AccRefundInformationListAdapter.CustomViewHolder>(){


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




        holder.text.text=RefundInformationList.get(position).toString()
        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/

    }
    override fun getItemCount(): Int {
        return RefundInformationList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //val switch = itemView.findViewById<Switch>(R.id.switch_button)

        val text = itemView.findViewById<TextView>(R.id.text_list)
    }

}


//리뷰s
class AccReviewListListAdapter(private val ReviewList: List<Review>) :RecyclerView.Adapter<AccReviewListListAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.acc_review_list_item, parent, false)//뷰를 붙여줌
        return CustomViewHolder(view)
                .apply {

                }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {//계속실행
        //holder.image.setImageResource.(goodsList.get(position).image)
        Glide.with(holder.img).load(ReviewList.get(position).reviewImage[0]).into(holder.img)
        //holder.img.setImageResource(RoomList.get(position).img as Int)
        holder.nickName.text=ReviewList.get(position).nickName
        holder.rating.rating=ReviewList.get(position).rating.toFloat()
        holder.time.text=ReviewList.get(position).dATE
        holder.roomName.text=ReviewList.get(position).roomName
        holder.reviewText.text=ReviewList.get(position).reviewText




        //holder.text.text=ReviewList.get(position).toString()
        //Log.d("aaaaaaaaaaaa",goodsList.get(position).img.toString())
        /*holder.name.text=goodsList.get(position).name
        holder.switch.isChecked=goodsList.get(position).switch.toString().toBoolean()*/

    }
    override fun getItemCount(): Int {
        return ReviewList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //val switch = itemView.findViewById<Switch>(R.id.switch_button)
        /*"reviewIdx": 1,
        "nickName": "초란색",
        "rating": 9,
        "roomName": "스탠다드 트윈",
        "reviewText": "친구들과 함꼐 첫 부산여행이었는데 탁월한 숙소 선택이었던 것 같습니다",
        "DATE": "2021-03-19 08:47:15"*/
        val rating=itemView.findViewById<RatingBar>(R.id.rating_star)
        val time=itemView.findViewById<TextView>(R.id.text_time)
        val roomName=itemView.findViewById<TextView>(R.id.text_roomName)
        val nickName=itemView.findViewById<TextView>(R.id.text_nickName)
        val reviewText = itemView.findViewById<TextView>(R.id.text_review)
        val img = itemView.findViewById<ImageView>(R.id.review_img)
    }

}