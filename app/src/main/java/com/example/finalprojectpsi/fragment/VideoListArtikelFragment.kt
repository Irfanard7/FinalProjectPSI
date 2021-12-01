package com.example.finalprojectpsi.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectpsi.HalamanArtikelActivity
import com.example.finalprojectpsi.HalamanVideoActivity
import com.example.finalprojectpsi.R
import com.example.finalprojectpsi.adapter.VideoListArtikel
import com.example.finalprojectpsi.model.Artikel
import com.example.finalprojectpsi.model.VideoArtikel
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class VideoListArtikelFragment : Fragment() {
    lateinit var recycler : RecyclerView
    lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Firebase.database.reference.child("video")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video_list_artikel, container, false)
        val data = ArrayList<VideoArtikel>()
        recycler = view.findViewById(R.id.list)
        val videoAdapter = VideoListArtikel(data, View.OnClickListener {
            val ind = data.size - 1 - recycler.indexOfChild(it)
            val intent = Intent(context, HalamanVideoActivity::class.java)
            intent.putExtra("judul", data[ind].judul)
            intent.putExtra("author", data[ind].author)
            intent.putExtra("tanggal", data[ind].date)
            intent.putExtra("desc", data[ind].deskripsi)
            intent.putExtra("videoId", data[ind].videoId)
            startActivity(intent)
        })

        recycler.adapter = videoAdapter
        recycler.layoutManager = LinearLayoutManager(context)

        val listener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var ind =0
                for (art in snapshot.children){
                    data.add(art.getValue<VideoArtikel>()!!)
                }
                videoAdapter.notifyItemRangeChanged(0, data.size)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "gagal memuat artikel", Toast.LENGTH_LONG).show()
            }

        }
        db.addValueEventListener(listener)
        return view
    }
}