package com.example.finalprojectpsi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.finalprojectpsi.R
import com.example.finalprojectpsi.adapter.MySliderImageAdapter
import com.smarteist.autoimageslider.SliderView
import org.w3c.dom.Text

class FrontPageFragment : Fragment() ,View.OnClickListener {
    lateinit var littleBox1 : TextView
    lateinit var littleBox2 : TextView
    lateinit var littleBox3 : TextView
    lateinit var littleBox4 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_front_page, container, false)
        val imageSlider = view.findViewById<SliderView>(R.id.imageSlider)
        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg")
        imageList.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
        imageList.add("https://media.istockphoto.com/photos/child-hands-formig-heart-shape-picture-id951945718?k=6&m=951945718&s=612x612&w=0&h=ih-N7RytxrTfhDyvyTQCA5q5xKoJToKSYgdsJ_mHrv0=")
        setImageInSlider(imageList, imageSlider)
        view.findViewById<TextView>(R.id.Terkonfirmasi).text = "Terkonfirmasi : "+323424
        view.findViewById<TextView>(R.id.Sembuh).text = "Sembuh : " + 123415
        view.findViewById<TextView>(R.id.Meninggal).text = "Meninggal : " + 9425
        return view
    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        val adapter = MySliderImageAdapter()
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
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