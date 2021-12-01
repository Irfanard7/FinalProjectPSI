package com.example.finalprojectpsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalprojectpsi.databinding.ActivityHalamanArtikelBinding

class HalamanArtikelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHalamanArtikelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityHalamanArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent != null){
            binding.tvJudul.text = intent.getStringExtra("judul")
            binding.tvAuthor.text = "Author : " + intent.getStringExtra("author")
            binding.tvDate.text = intent.getStringExtra("tanggal")
            binding.tvContent.text = intent.getStringExtra("desc")
        }

        binding.backMenu.setOnClickListener{finish()}
    }
}