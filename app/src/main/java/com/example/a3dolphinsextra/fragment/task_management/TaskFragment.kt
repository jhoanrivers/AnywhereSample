package com.example.a3dolphinsextra.fragment.task_management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3dolphinsextra.Adapter.TaskAdapter
import com.example.a3dolphinsextra.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    lateinit var binding: FragmentTaskBinding
    lateinit var modelViewTask: TaskModelView
    lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance(myToken: String) = TaskFragment().apply {
            arguments = Bundle().apply {
                putString("token", myToken)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        val v = binding.root
        binding.rvListTask.layoutManager = LinearLayoutManager(activity)
        modelViewTask = ViewModelProvider(this).get(TaskModelView::class.java)
        modelViewTask.mutableListTask.observe(this, Observer {
            adapter = TaskAdapter(it)
            binding.rvListTask.adapter = adapter
        })
        modelViewTask.getListTask()
        return v
    }




}