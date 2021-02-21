package com.gibran.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gibran.marvelapp.databinding.MainActivityBinding
import com.gibran.marvelapp.ui.screen.main.MainFragment

class MainActivity : AppCompatActivity() {
    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}