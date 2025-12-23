package com.example.scoreboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val score = MutableLiveData<Int>(0)

    fun addOne() {
        // Récupération de valeur initial + l'Ajoute de 1
        val actualValue = score.value ?: 0
        score.value = actualValue + 1

    }

}
