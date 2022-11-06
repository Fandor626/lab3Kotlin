package com.example.lab3kotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3kotlin.adapter.GameAdapter
import com.example.lab3kotlin.databinding.ActivityMainGameBinding
import com.example.lab3kotlin.viewModel.GameViewModel

class MainGameActivity: AppCompatActivity(){

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: ActivityMainGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        viewModel.getGameData()

        val recyclerView: RecyclerView = binding.gameList
        recyclerView.adapter = GameAdapter(viewModel.gameLiveData.value!!)
    }
}