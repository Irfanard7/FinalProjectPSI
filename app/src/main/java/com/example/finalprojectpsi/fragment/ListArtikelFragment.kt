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
import com.example.finalprojectpsi.R
import com.example.finalprojectpsi.adapter.ListArtikel
import com.example.finalprojectpsi.model.Artikel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ListArtikelFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var db : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Firebase.database.reference.child("artikel")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_artikel, container, false)
        recyclerView = view.findViewById(R.id.list)
        val data = ArrayList<Artikel>()
        val adapter = ListArtikel(data, View.OnClickListener {
            val ind = data.size - 1 -  recyclerView.indexOfChild(it)
            val intent = Intent(context, HalamanArtikelActivity::class.java)
            intent.putExtra("judul", data[ind].judul)
            intent.putExtra("author", data[ind].author)
            intent.putExtra("tanggal", data[ind].waktu)
            intent.putExtra("desc", data[ind].desc)

            startActivity(intent)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        val dataListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var ind =0
                for (art in snapshot.children){
                    data.add(art.getValue<Artikel>()!!)
                }
                adapter.notifyItemRangeChanged(0, data.size)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "gagal memuat artikel", Toast.LENGTH_LONG).show()
            }
        }
        db.addValueEventListener(dataListener)
        return view
    }
}