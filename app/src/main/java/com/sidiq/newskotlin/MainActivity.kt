@file:Suppress("DEPRECATION")

package com.sidiq.newskotlin

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle
import com.sidiq.newskotlin.adapter.BeritaAdapter
import com.sidiq.newskotlin.model.ArticlesItem
import com.sidiq.newskotlin.model.ResponServer
import com.sidiq.newskotlin.network.ApiSecvice
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val progressBar: ProgressBar = spin_kti3
        val doubleBounce: Sprite = Circle()
        progressBar.setIndeterminateDrawable(doubleBounce)



        if (isConnect()) {
            showLoading(true)
            loadData()
        } else {
            showLoading(true)
            Toast.makeText(this, "device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }


    }

    private fun loadData() {
        ApiSecvice.getRetrofit().getDataBerita().enqueue(object : retrofit2.Callback<ResponServer> {
            override fun onFailure(call: Call<ResponServer>, t: Throwable) {


                Log.e("data onFailure", " " + t.message)
            }

            override fun onResponse(call: Call<ResponServer>, response: Response<ResponServer>) {
                if (response.isSuccessful) {
                    val data = response.body()?.articles
                    showLoading(false)
                    showData(data)
                    Log.e("error server", "data tidak masuk ")

                }

            }
        });


    }

    fun isConnect(): Boolean {

        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }


    private fun showData(data: List<ArticlesItem>?) {

        mRecylerView.adapter = BeritaAdapter(data)
    }

    private fun showLoading(state: Boolean) {
        val progressBar: ProgressBar = spin_kti3
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }


}