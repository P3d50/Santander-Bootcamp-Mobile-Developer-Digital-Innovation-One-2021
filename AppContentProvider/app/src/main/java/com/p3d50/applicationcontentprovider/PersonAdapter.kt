package com.p3d50.applicationcontentprovider

import android.app.Person
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.FIRST_NAME
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.LAST_NAME

class PersonAdapter(private val listener:PersonClickedListener):RecyclerView.Adapter<PersonViewHolder>() {


    private var mCursor: Cursor?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_card_item,parent,false))

    override fun getItemCount(): Int = if(mCursor !=null) mCursor?.count as  Int else 0

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        mCursor?.moveToPosition(position)

        holder.personFirstName.text=mCursor?.getString(mCursor?.getColumnIndex(FIRST_NAME) as Int)
        holder.personLastName.text=mCursor?.getString(mCursor?.getColumnIndex(LAST_NAME) as Int)
        holder.personButtonRemove.setOnClickListener{
            mCursor?.moveToPosition(position)
            listener.personRemoveItem(mCursor as Cursor)
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener { listener.personClickedItem(mCursor as Cursor) }
      }



    fun setCursor(newCursor:Cursor?){
        mCursor =  newCursor
        notifyDataSetChanged()
    }
}

class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    val personFirstName = itemView.findViewById(R.id.person_first_name) as TextView
    val personLastName = itemView.findViewById(R.id.person_last_name) as TextView
    val personButtonRemove = itemView.findViewById(R.id.person_button_remove) as Button
}