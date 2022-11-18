package com.gautam.json_passing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gautam.json_passing.Adepter.CustomRecyclerAdepter
import com.gautam.json_passing.Network.ApiClint
import com.gautam.json_passing.Network.ApiService
import com.gautam.json_passing.databinding.ActivityMainBinding
import com.gautam.json_passing.modal.User
import com.gautam.json_passing.modal.callbackRespons
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding
    //lateinit var retrofit:Retrofit
    //lateinit var service:ApiService
    lateinit var adapter:CustomRecyclerAdepter
     private  var userlist:MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // initRetrofit()

        initRecycler()
        loadUserList()


    }

   /* private fun initRetrofit() {

        retrofit=Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service=retrofit.create(ApiService::class.java)

    }*/


    private fun initRecycler() {


      adapter= CustomRecyclerAdepter(this, userlist)
      binding.recyclerUser.layoutManager=LinearLayoutManager(this)
        binding.recyclerUser.adapter=adapter

    }

    private fun loadUserList() {

         binding.progressBar.visibility=View.VISIBLE

        ApiClint.init().getUserList().enqueue(object :Callback<callbackRespons>{
            override fun onResponse(
                call: Call<callbackRespons>,
                response: Response<callbackRespons>
            ) {
                binding.progressBar.visibility=View.GONE

                //Log.d("RESPONSE","onresponse:${response.body()}")
                if (response.isSuccessful){

                    var res=response.body()
                    res?.let{
                        adapter.setiteam(it.userlist)

                    }


                }
            }
            override fun onFailure(call: Call<callbackRespons>, t: Throwable) {
                binding.progressBar.visibility=View.GONE
                // falied
                Log.d("FAILED", "onFailure: ${t.message}")

            }

        })


    }
}