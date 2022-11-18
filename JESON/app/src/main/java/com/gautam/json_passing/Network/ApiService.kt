package com.gautam.json_passing.Network


import com.gautam.json_passing.modal.callbackRespons
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


      @GET("users?page=2 ")
      fun getUserList():Call<callbackRespons>



}


