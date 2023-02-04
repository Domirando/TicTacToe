package com.example.tictactoe

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var players = arrayOf("Maftuna", "Ma'mura")
    var players_scores = arrayOf<Int>(0, 0)
    var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pl0 = intent.getStringExtra("pl0")
        val pl1 = intent.getStringExtra("pl1")
        players[0] = pl0.toString()
        players[1] = pl1.toString()
        val actionBar = supportActionBar
        actionBar!!.title = "Good luck on TicTacToe!"
        actionBar.setDisplayHomeAsUpEnabled(true)

        active_player.text = "Player "+players[0]
        player0.text = players[0]
        player1.text = players[1]
        player0_score.text = players_scores[0].toString()
        player1_score.text = players_scores[1].toString()
        img0.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)
        img7.setOnClickListener(this)
        img8.setOnClickListener(this)
        restart.setOnClickListener {
            restart()
        }

    }

    override fun onClick(p0: View?) {
        val img = findViewById<ImageView>(p0!!.id)
        var t = img.tag.toString().toInt()
        var col: Int = t / 3
        var row: Int = t % 3
        if (matrix[col][row] == -1) {
            if (active) {
                img.setImageResource(R.drawable.x)
                active = false
                matrix[col][row] = 1
                active_player.text = "Player " + players[1]
                isWinner(1)
            } else {
                img.setImageResource(R.drawable._0)
                active = true
                matrix[col][row] = 0
                active_player.text = "Player " + players[0]
                isWinner(0)
            }
        }


    }

    fun isWinner(a: Int) {
        var count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + players[a]
                players_scores[a]++
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + players[a]
                players_scores[a]++
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            winner.text = "Winner is " + players[a]
            players_scores[a]++
            finishGame()
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            winner.text = "Winner is " + players[a]
            players_scores[a]++
            finishGame()
            return
        }
    }

    fun finishGame() {
        img0.isEnabled = false
        img1.isEnabled = false
        img2.isEnabled = false
        img3.isEnabled = false
        img4.isEnabled = false
        img5.isEnabled = false
        img6.isEnabled = false
        img7.isEnabled = false
        img8.isEnabled = false
        restart.visibility = View.VISIBLE
        player0_score.text = players_scores[0].toString()
        player1_score.text = players_scores[1].toString()
    }

    fun restart() {
        matrix = Array(3) { IntArray(3) { -1 } }
        active = true
        active_player.text = "Player " + players[0]

        restart.visibility = View.INVISIBLE

        winner.text = ""

        img0.isEnabled = true
        img1.isEnabled = true
        img2.isEnabled = true
        img3.isEnabled = true
        img4.isEnabled = true
        img5.isEnabled = true
        img6.isEnabled = true
        img7.isEnabled = true
        img8.isEnabled = true

        img0.setImageDrawable(null)
        img1.setImageDrawable(null)
        img2.setImageDrawable(null)
        img3.setImageDrawable(null)
        img4.setImageDrawable(null)
        img5.setImageDrawable(null)
        img6.setImageDrawable(null)
        img7.setImageDrawable(null)
        img8.setImageDrawable(null)

    }
}