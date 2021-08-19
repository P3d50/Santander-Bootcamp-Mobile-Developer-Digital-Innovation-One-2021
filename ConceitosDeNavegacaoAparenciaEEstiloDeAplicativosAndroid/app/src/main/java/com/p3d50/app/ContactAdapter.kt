package com.p3d50.app

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list:MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapter.ContactAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ContactAdapterViewHolder(intemView: View) : RecyclerView.ViewHolder(intemView){

    }

}