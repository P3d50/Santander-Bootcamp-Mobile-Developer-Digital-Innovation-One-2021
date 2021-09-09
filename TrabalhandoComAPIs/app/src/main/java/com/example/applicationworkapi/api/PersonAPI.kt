package com.example.applicationworkapi.api

import com.example.applicationworkapi.model.Person
import retrofit2.Call
import retrofit2.http.GET

interface PersonAPI {
    @GET("/api/v1/people")
    fun getPersonApi():Call<List<Person>>
}