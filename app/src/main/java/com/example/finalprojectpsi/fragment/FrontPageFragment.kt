package com.example.finalprojectpsi.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.finalprojectpsi.R
import com.example.finalprojectpsi.adapter.ListArtikel
import com.example.finalprojectpsi.adapter.MySliderImageAdapter
import com.example.finalprojectpsi.model.Artikel
import com.example.finalprojectpsi.model.VideoArtikel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.smarteist.autoimageslider.SliderView
import org.w3c.dom.Text
import android.content.ActivityNotFoundException
import androidx.core.view.allViews

import com.example.finalprojectpsi.MainActivity
import java.lang.Exception


class FrontPageFragment : Fragment() ,View.OnClickListener {
    lateinit var littleBox1 : TextView
    lateinit var littleBox2 : TextView
    lateinit var littleBox3 : TextView
    lateinit var littleBox4 : TextView

    lateinit var data : ArrayList<String>
    lateinit var db : DatabaseReference
    lateinit var radapter : MySliderImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = ArrayList()
        db = Firebase.database.reference.child("video")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_front_page, container, false)
        val imageSlider = view.findViewById<SliderView>(R.id.imageSlider)
        view.findViewById<TextView>(R.id.Terkonfirmasi).text = "Terkonfirmasi : "+323424
        view.findViewById<TextView>(R.id.Sembuh).text = "Sembuh : " + 123415
        view.findViewById<TextView>(R.id.Meninggal).text = "Meninggal : " + 9425

        val dataListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var ind =0
                for (art in snapshot.children){
                    data.add(art.child("videoId").value.toString())
                }

                setImageInSlider(data, imageSlider)
                radapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "gagal memuat artikel", Toast.LENGTH_LONG).show()
            }
        }
        db.addValueEventListener(dataListener)

        return view
    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        radapter = MySliderImageAdapter {
            var ind = imageSlider.currentPagePosition
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.google.android.youtube")
            intent.data = Uri.parse("http://www.youtube.com/watch?v=" + data[ind])
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "Gagal membuka Youtube!", Toast.LENGTH_LONG).show()
            }
        }
        radapter.renewItems(images)
        imageSlider.setSliderAdapter(radapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.littleBox1->{
                Toast.makeText(context,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
            R.id.littleBox2->{
                Toast.makeText(context,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
            R.id.littleBox3->{
                Toast.makeText(context,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
            R.id.littleBox4->{
                Toast.makeText(context,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}