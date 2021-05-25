package com.sondari.dicoding.fundamentalsatu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter(val listUser:ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    internal fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var username: TextView = itemView.findViewById(R.id.tv_item_name)
        var detail: TextView = itemView.findViewById(R.id.tv_item_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val user = listUser[position]
        
        Glide.with(holder.itemView.context)
            .load(listUser[position].avatar)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        
        holder.username.text = user.name
        holder.detail.text = user.username
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setData(itemUser: ArrayList<User>) {
        listUser.clear()

        listUser.addAll(itemUser)

        notifyDataSetChanged()
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}