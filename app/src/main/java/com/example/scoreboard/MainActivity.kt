package com.example.scoreboard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // L'initialisation du ViewModel
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val textScore = findViewById<TextView>(R.id.text_counter)
        val addButton = findViewById<Button>(R.id.click_button)

        // Observation : Si le score change dans le ViewModel, on met a jour le texte
        viewModel.score.observe(this) { newScore ->
            textScore.text = newScore.toString()
        }

        // L'action de Click --> on demande le ViewModel de faire le travail
        addButton.setOnClickListener {
            viewModel.addOne()
        }


    }
}
