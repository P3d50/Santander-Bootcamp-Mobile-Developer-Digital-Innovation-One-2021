package com.example.applicationworkapi.model

import com.google.gson.annotations.SerializedName

class Phone (

    @SerializedName("id")
    val  id:String,
    @SerializedName("type")
    val type:String,
    @SerializedName("number")
    val phone:String
){
    override fun toString(): String {
        return "$phone "
    }
}