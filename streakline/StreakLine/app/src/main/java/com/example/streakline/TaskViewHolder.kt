package com.example.streakline

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val ivTaskDel:ImageView = view.findViewById(R.id.ivTaskDel)
    fun render(task:String, onItemDel:(Int) -> Unit){
        tvTask.text = task
        ivTaskDel.setOnClickListener { onItemDel(adapterPosition) }
    }
}