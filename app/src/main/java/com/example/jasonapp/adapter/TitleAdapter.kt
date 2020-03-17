package com.example.jasonapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jasonapp.R
import com.example.jasonapp.model.Title
import kotlinx.android.synthetic.main.item_title.view.*

class TitleAdapter(var titleList: ArrayList<Title>) :
    RecyclerView.Adapter<TitleAdapter.titleViewHolder>() {

    inner class titleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(title: Title) {
            itemView.txt_title.text = title.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): titleViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false)
        return titleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: titleViewHolder, position: Int) {
        holder.bind(titleList[position])
    }
}