package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalprojectpsi.databinding.ActivityHalamanVideoBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class HalamanVideoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHalamanVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanVideoBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.backMenu.setOnClickListener{finish()}

        if(intent != null){
            binding.tvJudul.text = intent.getStringExtra("judul")
            binding.tvAuthor.text = "Author : " + intent.getStringExtra("author")
            binding.tvDate.text = intent.getStringExtra("tanggal")
            binding.tvDeskripsi.text = intent.getStringExtra("desc")

        }
        lifecycle.addObserver(binding.video)
        binding.video.addYouTubePlayerListener( object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(intent.getStringExtra("videoId").toString(), 0F)
            }
        })
    }
}