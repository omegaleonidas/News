package com.sidiq.newskotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sidiq.newskotlin.DetailActivity
import com.sidiq.newskotlin.R
import com.sidiq.newskotlin.model.ArticlesItem

import kotlinx.android.synthetic.main.item_data.view.*

class BeritaAdapter(val data: List<ArticlesItem?>?) :
    RecyclerView.Adapter<BeritaAdapter.BeritaHolder>() {


    class BeritaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textName = itemView.txttitle
        val textDescription = itemView.txtDesc
        val imageView = itemView.imageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        val holder = BeritaHolder(view)
        return holder

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: BeritaAdapter.BeritaHolder, position: Int) {

        holder.textName.text = data?.get(position)?.title
        holder.textDescription.text = data?.get(position)?.description
        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            val intent  = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("judul",data?.get(position)?.title)
            intent.putExtra("fhoto",data?.get(position)?.urlToImage)
            intent.putExtra("descripsi",data?.get(position)?.description)

            holder.itemView.context.startActivity(intent)
        }


    }
}