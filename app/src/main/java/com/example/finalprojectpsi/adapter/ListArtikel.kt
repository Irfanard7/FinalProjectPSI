package com.example.finalprojectpsi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectpsi.R
import com.example.finalprojectpsi.model.Artikel
import com.mikhaellopez.circularimageview.CircularImageView

class ListArtikel(var listArtikel : ArrayList<Artikel>, val onclick : View.OnClickListener) :
    RecyclerView.Adapter<ListArtikel.ArtikelViewHolder>() {
    class ArtikelViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var judul = view.findViewById<TextView>(R.id.judul_list)
        var desc = view.findViewById<TextView>(R.id.desc_list)
        var image = view.findViewById<CircularImageView>(R.id.image_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_artikel,parent, false)
        view.setOnClickListener(onclick)
        return ArtikelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        val ind = itemCount - 1 - position
        holder.judul.text = listArtikel[ind].judul
        holder.desc.text = listArtikel[ind].desc
    }

    override fun getItemCount(): Int = listArtikel.size
}