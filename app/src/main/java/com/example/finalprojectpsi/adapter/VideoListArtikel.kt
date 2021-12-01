package com.example.finalprojectpsi.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectpsi.R
import com.example.finalprojectpsi.model.Artikel
import com.example.finalprojectpsi.model.VideoArtikel
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso
import java.net.URL

class VideoListArtikel(var videoList : ArrayList<VideoArtikel>, val onClick : View.OnClickListener) : RecyclerView.Adapter<VideoListArtikel.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var judul = view.findViewById<TextView>(R.id.judul_list)
        var desc = view.findViewById<TextView>(R.id.desc_list)
        var banner = view.findViewById<ImageView>(R.id.banner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_video, parent,false)
        view.setOnClickListener(onClick)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ind = itemCount - 1 - position
        holder.judul.text = videoList[ind].judul
        holder.desc.text = videoList[ind].deskripsi
        Picasso.get().load("https://img.youtube.com/vi/"+videoList[ind].videoId+"/0.jpg").into(holder.banner)
    }

    override fun getItemCount(): Int = videoList.size
}