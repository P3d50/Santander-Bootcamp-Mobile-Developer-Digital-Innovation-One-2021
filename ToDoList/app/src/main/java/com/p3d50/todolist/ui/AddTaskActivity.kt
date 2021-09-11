package com.p3d50.todolist.ui

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.p3d50.todolist.databinding.ActivityAddTaskBinding
import com.p3d50.todolist.datasource.TaskDataSource
import com.p3d50.todolist.extensions.format
import com.p3d50.todolist.extensions.text
import com.p3d50.todolist.model.Task
import java.util.*

class AddTaskActivity:AppCompatActivity() {

    private lateinit var binding:ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra(TASK_ID)){
            val taskId = intent.getIntExtra(TASK_ID,0)
            TaskDataSource.findById(taskId)?.let {
                binding.textInputLayoutTitle.text = it.title
                binding.textInputLayoutDescription.text = it.description
                binding.textInputLayoutDate.text = it.date
                binding.textInputLayoutTime.text = it.hour
            }
        }
        insertListeners()

    }

    private fun insertListeners() {
        binding.textInputLayoutDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("selecione a data da tarefa")
                .build()
            datePicker.addOnPositiveButtonClickListener {
                val timezone = TimeZone.getDefault()
                val offSet = timezone.getOffset(Date().time) * -1
                binding.textInputLayoutDate.text = Date(it+offSet).format()
            }
            datePicker.show(supportFragmentManager,"DATE_PICKER_TAG")
        }


        binding.textInputLayoutTime.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()
            timePicker.addOnPositiveButtonClickListener {
                binding.textInputLayoutTime.text ="${timePicker.hour}:${timePicker.minute}"
            }
            timePicker.show(supportFragmentManager,null)
        }

        binding.buttonCancelCreateTask.setOnClickListener {
            finish()
        }

        binding.buttonCreateTask.setOnClickListener {
            val task = Task(
                binding.textInputLayoutTitle.text,
                binding.textInputEditTextDescription.text.toString(),
                binding.textInputLayoutDate.text,
                binding.textInputLayoutTime.text,
                intent.getIntExtra(TASK_ID,0)
            )
            TaskDataSource.insertTask(task)
            setResult(Activity.RESULT_OK)
            finish()
        }

    }

    companion object{
        const val TASK_ID = "task_id"
    }
}