package com.gautam.json_passing.Adepter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gautam.json_passing.R
import com.gautam.json_passing.databinding.ActivityGridBinding
import com.gautam.json_passing.modal.User
class CustomRecyclerAdepter(var context: Context,var userlist:MutableList<User>):RecyclerView.Adapter<CustomRecyclerAdepter.MyViewHolder>(){

   class MyViewHolder(val binding: ActivityGridBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

    return MyViewHolder(ActivityGridBinding.inflate(LayoutInflater.from(context),parent,false))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            var User=userlist[position]
        holder.binding.tvName.text = "${User.firstName} ${User.lastName}"
        holder.binding.tvEmail.text = User.email
        Glide.with(context)
             .load(User.imageUrl)
             .centerCrop()
             .placeholder(R.drawable.hourglass)
             .into(holder.binding.ivThumbnail)
    }
    override fun getItemCount(): Int {
         return userlist.size
    }
    fun setiteam(newUserList: MutableList<User>){
        userlist=newUserList
        notifyDataSetChanged()  //to refresh recyclerview adapter
    }
}
