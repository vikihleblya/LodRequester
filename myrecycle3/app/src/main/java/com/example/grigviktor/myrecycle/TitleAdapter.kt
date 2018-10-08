package com.example.grigviktor.myrecycle

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class TitleAdapter(val context: Context, val titles: List<PersonNeed>) : RecyclerView.Adapter<TitleAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = titles.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = titles[position]
        holder.setData(item)
    }

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(title: PersonNeed?){
            itemView.description_of_application.text = title!!.title
            itemView.tags.text = title!!.Tag
        }
    }

}