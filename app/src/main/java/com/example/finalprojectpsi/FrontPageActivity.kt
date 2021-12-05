package com.example.finalprojectpsi

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectpsi.adapter.MySliderImageAdapter
import com.smarteist.autoimageslider.SliderView

class FrontPageActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var littleBox1 : TextView
    lateinit var littleBox2 : TextView
    lateinit var littleBox3 : TextView
    lateinit var littleBox4 : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frontpage)
        val imageSlider = findViewById<SliderView>(R.id.imageSlider)
        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg")
        imageList.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
        imageList.add("https://media.istockphoto.com/photos/child-hands-formig-heart-shape-picture-id951945718?k=6&m=951945718&s=612x612&w=0&h=ih-N7RytxrTfhDyvyTQCA5q5xKoJToKSYgdsJ_mHrv0=")
        setImageInSlider(imageList, imageSlider)


        littleBox1 = findViewById(R.id.littleBox1)
        littleBox1.setOnClickListener(this)
        littleBox2 = findViewById(R.id.littleBox2)
        littleBox2.setOnClickListener(this)
        littleBox3 = findViewById(R.id.littleBox3)
        littleBox3.setOnClickListener(this)
        littleBox4 = findViewById(R.id.littleBox4)
        littleBox4.setOnClickListener(this)

    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.littleBox1->{
                Toast.makeText(applicationContext,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
            R.id.littleBox2->{
                Toast.makeText(applicationContext,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
            R.id.littleBox3->{
                Toast.makeText(applicationContext,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
            R.id.littleBox4->{
                Toast.makeText(applicationContext,"Click was heard!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}