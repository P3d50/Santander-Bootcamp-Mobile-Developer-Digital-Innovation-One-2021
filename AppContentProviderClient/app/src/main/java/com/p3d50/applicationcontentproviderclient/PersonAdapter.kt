package com.p3d50.applicationcontentproviderclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val mCursor:Cursor):RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item,parent,false))

    override fun getItemCount(): Int = mCursor.count

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.personFirstName.text = mCursor.getString(mCursor.getColumnIndex("first_name"))
        holder.personLastName.text = mCursor.getString(mCursor.getColumnIndex("last_name"))
    }


}



class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val personFirstName = itemView.findViewById(R.id.person_item_first_name) as TextView
    val personLastName = itemView.findViewById(R.id.person_item_last_name) as TextView

}