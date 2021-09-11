package com.p3d50.todolist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.p3d50.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.taskAddFloatingActionButton.setOnClickListener {
            startActivity(Intent(this,AddTaskActivity::class.java))
        }
    }
}