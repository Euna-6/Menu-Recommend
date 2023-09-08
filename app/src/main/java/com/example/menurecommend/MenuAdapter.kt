package com.example.menurecommend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(val itemList : java.util.ArrayList<String>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        //holder.tvItem.text = itemList[position].menu
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class MenuViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvItem = itemView.findViewById<TextView>(R.id.tv_item)
        fun bind(menuItem : String){
            tvItem.text = menuItem
        }
    }
}