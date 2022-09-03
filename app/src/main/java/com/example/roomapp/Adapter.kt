package com.example.roomapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(val data: List<userdata>):RecyclerView.Adapter<viewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
       val inflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.itemview,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.data2.text=data[position].username
    }

}

class viewholder(itemview:View):RecyclerView.ViewHolder(itemview){
    val data2=itemview.findViewById<TextView>(R.id.textview)

}
