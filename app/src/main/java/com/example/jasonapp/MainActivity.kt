package com.example.jasonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jasonapp.adapter.TitleAdapter
import com.example.jasonapp.api.TitleApi
import com.example.jasonapp.model.Title
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTitlek()
    }
    fun getTitlek(){
        var baseUrl="https://jsonplaceholder.typicode.com"
        var retrofit=Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService=
            retrofit.create(TitleApi::class.java)
        var apiCall=retrofitService.getTitle()
        apiCall.enqueue(object :Callback<List<Title>>{
            override fun onFailure(call: Call<List<Title>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Title>>, response: Response<List<Title>>) {
                val titleList=response.body()
                Log.d("response>>>>",titleList.toString())
                val adapterA=TitleAdapter(titleList as ArrayList<Title>)

                recTitle.apply {
                    layoutManager= LinearLayoutManager(this@MainActivity)
                    adapter=adapterA
                }

            }


        }
        )

    }
}
