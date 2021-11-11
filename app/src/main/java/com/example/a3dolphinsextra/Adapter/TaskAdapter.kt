package com.example.a3dolphinsextra.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3dolphinsextra.R
import com.example.a3dolphinsextra.databinding.ItemTaskBinding
import com.example.a3dolphinsextra.model.TaskModel

class TaskAdapter(val listTask : List<TaskModel>): RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    class TaskHolder(val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TaskHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val task = listTask[position]

        holder.binding.tvTaskName.text = task.taskName
        holder.binding.tvCreatedBy.text = task.createdBy

    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}