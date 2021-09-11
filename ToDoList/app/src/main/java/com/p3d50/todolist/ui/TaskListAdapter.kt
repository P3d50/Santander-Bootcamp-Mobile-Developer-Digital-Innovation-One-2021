package com.p3d50.todolist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.p3d50.todolist.R
import com.p3d50.todolist.databinding.ItemTaskBinding
import com.p3d50.todolist.model.Task

class TaskListAdapter: ListAdapter<Task, TaskListAdapter.TaskViewHolder>(DiffCallBack()) {

    var listenerEdit: (Task) -> Unit ={}
    var listenerDelete: (Task) -> Unit ={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater,parent,false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCurrentListChanged(
        previousList: MutableList<Task>,
        currentList: MutableList<Task>
    ) {
        super.onCurrentListChanged(previousList, currentList)
        this.notifyDataSetChanged()
    }

    inner class TaskViewHolder(
        private val binding:ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Task) {
                binding.textViewTaskTitle.text = item?.title
                binding.textViewTaskDescription.text = item?.description
                binding.textViewTaskDate.text = "${item?.date}:${item?.hour}"
                binding.imageViewTaskItemOptions.setOnClickListener {
                        showPopup(item)
                }
        }

        private fun showPopup(item:Task) {
            val imageViewTaskItemOptions =binding.imageViewTaskItemOptions
            val popupMenu = PopupMenu(
                imageViewTaskItemOptions.context,
                imageViewTaskItemOptions
            )
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_edit_task -> listenerEdit(item)
                    R.id.action_delete_task -> listenerDelete(item)
                }
                return@setOnMenuItemClickListener true
            }
            popupMenu.show()

        }
    }


}


class DiffCallBack:DiffUtil.ItemCallback<Task>(){
    override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id
}