package com.sidiq.newskotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiSecvice {

    companion object {
        fun getRetrofit(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val  secvice = retrofit.create(ApiInterface::class.java)
            return secvice

        }
    }
}