 package com.example.applicationworkapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationworkapi.api.MyRetrofit
import com.example.applicationworkapi.model.Person
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class MainActivity : AppCompatActivity() {

    lateinit var recyclerPersons:  RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerPersons = findViewById(R.id.recycler_persons)
        recyclerPersons.layoutManager = LinearLayoutManager(this)
        getData()
    }

     private fun getData(){
            val call : Call<List<Person>> = MyRetrofit.instance?.personAPI()?.getPersonApi() as Call
         call.enqueue(object  : Callback<List<Person>>{
             override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                 Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG ).show()
             }

             override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                   val adapter = PersonAdapter(this@MainActivity, response.body()!!.toList())
                     recyclerPersons.adapter =  adapter
             }

         })
     }
}