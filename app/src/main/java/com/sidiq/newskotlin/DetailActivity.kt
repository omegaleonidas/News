package com.sidiq.newskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_data.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title  = intent.getStringExtra("judul")
        val image = intent.getStringExtra("fhoto")
        val desc = intent.getStringExtra("descripsi")
        Glide.with(this).load(image).into(txtImageDetail)

        txttitleDetail.setText(title)
        txtDecDetail.setText(desc)

    }
}