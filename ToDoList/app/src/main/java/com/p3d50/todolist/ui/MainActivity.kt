package com.p3d50.todolist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.p3d50.todolist.databinding.ActivityMainBinding
import com.p3d50.todolist.datasource.TaskDataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {TaskListAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerviewTasks.adapter = adapter
        updateTaskList()
        insertListeners()
    }

    private fun insertListeners() {
        binding.taskAddFloatingActionButton.setOnClickListener {
            startActivityForResult(Intent(this,AddTaskActivity::class.java), CREATE_NEW_TASK)

        }

        adapter.listenerEdit = {
            val intent = Intent(this,AddTaskActivity::class.java)
            intent.putExtra(AddTaskActivity.TASK_ID,it.id)
            startActivityForResult(intent, CREATE_NEW_TASK)
        }

        adapter.listenerDelete = {
            TaskDataSource.deleteTask(it)
            updateTaskList()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== CREATE_NEW_TASK && resultCode == Activity.RESULT_OK) updateTaskList()


    }


    private fun updateTaskList(){
        val list = TaskDataSource.getList()

        binding
            .includeLayoutTaskListEmptyState
            .layoutTaskListEmptyState
            .visibility = if(list.isEmpty())View.VISIBLE else View.GONE

        adapter.submitList(TaskDataSource.getList())

    }

    companion object{
        private const val CREATE_NEW_TASK = 1000
    }
}