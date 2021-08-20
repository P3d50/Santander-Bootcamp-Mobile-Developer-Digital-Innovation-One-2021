package com.p3d50.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list:MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapter.ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent, false)
        return ContactAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list:List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(intemView: View) : RecyclerView.ViewHolder(intemView){
        private val tvName: TextView = itemView.findViewById(R.id.textViewName)
        private val tvPhone: TextView = itemView.findViewById(R.id.textViewPhone)
        private val ivPhotography: ImageView = itemView.findViewById(R.id.imageViewPhotograph)

        fun bind(contact:Contact){
                tvName.text = contact.name
                tvPhone.text = contact.phone
        }
    }

}