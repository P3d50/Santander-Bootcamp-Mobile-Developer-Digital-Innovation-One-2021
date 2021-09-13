package com.example.applicationworkapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationworkapi.model.Person
import com.example.applicationworkapi.model.Phone

class PhoneAdapter(
    private val context: Context,
    private val phoneList:List<Phone>
): RecyclerView.Adapter<PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val phone = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_item,parent,false)
        return PhoneViewHolder(phone)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone: Phone = phoneList[position]
        holder.number.text = phone.number
        holder.type.text = phone.type
    }

    override fun getItemCount() = phoneList.size
}


class PhoneViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val number:TextView =  itemView.findViewById(R.id.text_view_phone_number)
    val type:TextView = itemView.findViewById(R.id.text_view_phone_type)


}
