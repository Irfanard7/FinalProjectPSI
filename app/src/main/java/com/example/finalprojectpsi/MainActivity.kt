package com.example.finalprojectpsi

import android.content.Context
import android.content.SharedPreferences
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
    private lateinit var shared: SharedPreferences
    private val sharedKey = "SHARED_MAIN_ACTIVITY"
    private var position = 0

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = getSharedPreferences(sharedKey, Context.MODE_PRIVATE)
        position = shared.getInt("position", 0)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.navigation)

        frontPage = FrontPageFragment()
        listArtikel = ListArtikelFragment()
        videoList = VideoListArtikelFragment()

        val transact = fragmentManager.beginTransaction()
        when(position){
            0->{
                transact.replace(R.id.fragment_container, frontPage)
            }
            1->{
                transact.replace(R.id.fragment_container, listArtikel)
            }
            2->{
                transact.replace(R.id.fragment_container, videoList)
            }
        }
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
                    position = 0
                }
                R.id.artikel_menu ->{
                    it.setIcon(R.drawable.artikel_selected)
                    transact.replace(R.id.fragment_container, listArtikel)
                    transact.commit()
                    position = 1
                }
                R.id.video_menu ->{
                    it.setIcon(R.drawable.video_selected)
                    transact.replace(R.id.fragment_container, videoList)
                    transact.commit()
                    position = 2
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        shared.edit().putInt("position", position).apply()
    }

}