package com.example.applicationworkapi.model

import com.google.gson.annotations.SerializedName

class Phone (

    @SerializedName("id")
    val  id:String,
    @SerializedName("type")
    val type:String,
    @SerializedName("number")
    val number:String
){
    override fun toString(): String {
        return "$number "
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Phone

        if (id != other.id) return false
        if (type != other.type) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + number.hashCode()
        return result
    }


}