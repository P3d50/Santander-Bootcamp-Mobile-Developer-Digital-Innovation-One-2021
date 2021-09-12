package com.example.applicationworkapi.model

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id")
     val  id:String,
     @SerializedName("firstName")
     val firstName:String,
     @SerializedName("lastName")
     val lastName:String,
     @SerializedName("phones")
    val phones:List<Phone> = ArrayList()
){


}