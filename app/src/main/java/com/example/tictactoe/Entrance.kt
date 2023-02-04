package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entrance.*

class Entrance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
        start_game.setOnClickListener{
            var player0 = player0_name.text
            var player1 = player1_name.text
            Intent(this, MainActivity::class.java).also {
                it.putExtra("pl0", player0.toString())
                it.putExtra("pl1", player1.toString())
                startActivity(it)
            }
        }
        val actionBar = supportActionBar
        actionBar!!.title = "Welcome to TicTacToe!"
    }
}