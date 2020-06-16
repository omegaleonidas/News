package com.sidiq.newskotlin.network

import com.sidiq.newskotlin.model.ResponServer

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/v2/everything?q=bitcoin&from=2020-05-16&sortBy=publishedAt&apiKey=82eb7229052b4cd68edd550a43353ebc")
    fun getDataBerita(): Call<ResponServer>
}