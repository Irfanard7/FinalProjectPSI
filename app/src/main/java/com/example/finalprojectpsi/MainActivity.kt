package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalprojectpsi.fragment.FrontPageFragment
import com.example.finalprojectpsi.fragment.ListArtikelFragment
import com.example.finalprojectpsi.fragment.VideoListArtikelFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var frontPage : FrontPageFragment
    private lateinit var listArtikel : ListArtikelFragment
    private lateinit var videoList : VideoListArtikelFragment
    private lateinit var navigation : BottomNavigationView

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.navigation)

        frontPage = FrontPageFragment()
        listArtikel = ListArtikelFragment()
        videoList = VideoListArtikelFragment()

        val transact = fragmentManager.beginTransaction()
        transact.add(R.id.fragment_container, frontPage)
        transact.commit()

        navigation.setOnItemSelectedListener {
            navigation.menu.getItem(0).setIcon(R.drawable.home2)
            navigation.menu.getItem(1).setIcon(R.drawable.artikel2)
            navigation.menu.getItem(2).setIcon(R.drawable.video2)
            val transact = fragmentManager.beginTransaction()
            when(it.itemId){
                R.id.home_menu ->{
                    it.setIcon(R.drawable.home_selected)
                    transact.replace(R.id.fragment_container, frontPage)
                    transact.commit()
                }
                R.id.artikel_menu ->{
                    it.setIcon(R.drawable.artikel_selected)
                    transact.replace(R.id.fragment_container, listArtikel)
                    transact.commit()
                }
                R.id.video_menu ->{
                    it.setIcon(R.drawable.video_selected)
                    transact.replace(R.id.fragment_container, videoList)
                    transact.commit()
                }
            }
            true
        }
    }


}