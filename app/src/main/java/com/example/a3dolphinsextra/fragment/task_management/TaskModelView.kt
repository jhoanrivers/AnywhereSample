package com.example.a3dolphinsextra.fragment.task_management

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a3dolphinsextra.global.prefs
import com.example.a3dolphinsextra.model.TaskListResponse
import com.example.a3dolphinsextra.model.TaskModel
import com.example.a3dolphinsextra.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskModelView: ViewModel() {

    var mutableListTask: MutableLiveData<List<TaskModel>>  = MutableLiveData()
    lateinit var listTask: List<TaskModel>

    fun getListTask(){
        var newToken = "Bearer ${prefs.token}"
        NetworkConfig.getService().getListTask("desc",0,10,"alltask","status",newToken)
            .enqueue(object: Callback<TaskListResponse>{
                override fun onResponse(
                    call: Call<TaskListResponse>,
                    response: Response<TaskListResponse>
                ) {
                    listTask = response.body()?.data ?: ArrayList<TaskModel>()
                    mutableListTask.value = listTask
                }

                override fun onFailure(call: Call<TaskListResponse>, t: Throwable) {
                    Log.e("Task Model View", t.localizedMessage!!)
                }

            })


    }



}