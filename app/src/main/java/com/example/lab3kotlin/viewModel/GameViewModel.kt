package com.example.lab3kotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab3kotlin.model.Game
import com.example.lab3kotlin.model.GameData

class GameViewModel: ViewModel() {

    private val gameData: GameData = GameData()
    private val _gameLiveData = MutableLiveData<List<Game>>()
    val gameLiveData: LiveData<List<Game>> = _gameLiveData

    fun getGameData(){
        _gameLiveData.value = gameData.gameList
    }
}