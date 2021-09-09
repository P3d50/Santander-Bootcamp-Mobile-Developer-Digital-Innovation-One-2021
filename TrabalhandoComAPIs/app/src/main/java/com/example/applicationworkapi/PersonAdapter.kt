package com.example.applicationworkapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationworkapi.model.Person

class PersonAdapter(
    private val contect:Context,
    private val personList:List<Person>
    ):RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder  =   PersonViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.person_card_item,parent,false))

    override fun getItemCount(): Int = personList.size



    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person: Person = personList[position]
        holder.firstName.text = person.firstName
        holder.lastname.text = person.lastName

      }
}

class PersonViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    val personImage:ImageView  = itemView.findViewById(R.id.person_image)
    val firstName : TextView  = itemView.findViewById(R.id.person_first_name)
     val lastname:TextView =  itemView .findViewById(R.id.person_last_name)

}