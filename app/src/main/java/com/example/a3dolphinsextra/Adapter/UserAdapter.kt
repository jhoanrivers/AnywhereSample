//package com.example.a3dolphinsextra.Adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.appcompat.view.menu.MenuView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.a3dolphinsextra.R
//import com.example.a3dolphinsextra.model.ResultUser
//
//
//class UserAdapter (private val data: ArrayList<ResultUser>?): RecyclerView.Adapter<UserAdapter.MyHolder>(){
//
//
//    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//
////
////        val name: TextView = itemView.findViewById(R.id.name)
////
////
////        fun bind(user: ResultUser?) {
////            name.text = user?.name
////
////        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
//
////        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
////        return MyHolder(v)
//        return
//    }
//
//    override fun onBindViewHolder(holder: MyHolder, position: Int) {
//        holder.bind(data?.get(position))
//    }
//
//    override fun getItemCount(): Int {
//        return data?.size ?: 0
//    }
//
//
//}