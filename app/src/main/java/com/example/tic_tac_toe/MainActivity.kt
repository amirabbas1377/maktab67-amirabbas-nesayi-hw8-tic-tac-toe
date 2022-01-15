package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var fieldOfGame = mutableListOf<Char?>(null, null, null, null, null, null, null, null, null)
    var countPlay = 0
    var isGameFinished = false
    lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game()
    }

    fun game() {
        val button11: Button = findViewById(R.id.button11)
        val button12: Button = findViewById(R.id.button12)
        val button13: Button = findViewById(R.id.button13)
        val button21: Button = findViewById(R.id.button21)
        val button22: Button = findViewById(R.id.button22)
        val button23: Button = findViewById(R.id.button23)
        val button31: Button = findViewById(R.id.button31)
        val button32: Button = findViewById(R.id.button32)
        val button33: Button = findViewById(R.id.button33)

        button11.setOnClickListener {
            if (fieldOfGame[0] == null && !isGameFinished) {
                fieldOfGame[0] = if (countPlay % 2 == 0) 'O' else 'X'
                button11.text = fieldOfGame[0].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button12.setOnClickListener {
            if (fieldOfGame[1] == null && !isGameFinished) {
                fieldOfGame[1] = if (countPlay % 2 == 0) 'O' else 'X'
                button12.text = fieldOfGame[1].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button13.setOnClickListener {
            if (fieldOfGame[2] == null && !isGameFinished) {
                fieldOfGame[2] = if (countPlay % 2 == 0) 'O' else 'X'
                button13.text = fieldOfGame[2].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button21.setOnClickListener {
            if (fieldOfGame[3] == null && !isGameFinished) {
                fieldOfGame[3] = if (countPlay % 2 == 0) 'O' else 'X'
                button21.text = fieldOfGame[3].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button22.setOnClickListener {
            if (fieldOfGame[4] == null && !isGameFinished) {
                fieldOfGame[4] = if (countPlay % 2 == 0) 'O' else 'X'
                button22.text = fieldOfGame[4].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button23.setOnClickListener {
            if (fieldOfGame[5] == null && !isGameFinished) {
                fieldOfGame[5] = if (countPlay % 2 == 0) 'O' else 'X'
                button23.text = fieldOfGame[5].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button31.setOnClickListener {
            if (fieldOfGame[6] == null && !isGameFinished) {
                fieldOfGame[6] = if (countPlay % 2 == 0) 'O' else 'X'
                button31.text = fieldOfGame[6].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button32.setOnClickListener {
            if (fieldOfGame[7] == null && !isGameFinished) {
                fieldOfGame[7] = if (countPlay % 2 == 0) 'O' else 'X'
                button32.text = fieldOfGame[7].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        button33.setOnClickListener {
            if (fieldOfGame[8] == null && !isGameFinished) {
                fieldOfGame[8] = if (countPlay % 2 == 0) 'O' else 'X'
                button33.text = fieldOfGame[8].toString()
                checkGame()
                countPlay++
            } else toastForWrongButton()
        }

        var listOfButtons = mutableListOf(
            button11, button12, button13, button21, button22, button23, button31, button32, button33
        )

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            for (item in listOfButtons) item.text = ""
            for (i in 0..8) fieldOfGame[i] = null
            isGameFinished = false
            resultView.text = ""
            countPlay = 0
        }
    }

    fun toastForWrongButton() {
        Toast.makeText(this, "this field selected or game is over", Toast.LENGTH_SHORT).show()
    }

    fun checkGame() {
        resultView = findViewById(R.id.result_text_view)
        for (i in 0..2) {
            if (fieldOfGame[3 * i] == fieldOfGame[3 * i + 1] && fieldOfGame[3 * i + 1] == fieldOfGame[3 * i + 2]) {
                if (fieldOfGame[3 * i + 1] == 'O') {
                    resultView.text = getString(R.string.game_result_string, 'O')
                    isGameFinished = true
                } else if (fieldOfGame[3 * i + 1] == 'X') {
                    resultView.text = getString(R.string.game_result_string, 'X')
                    isGameFinished = true
                }
            }
        }
        for (i in 0..2) {
            if (fieldOfGame[i] == fieldOfGame[i + 3] && fieldOfGame[i + 3] == fieldOfGame[i + 6]) {
                if (fieldOfGame[i + 3] == 'O') {
                    resultView.text = getString(R.string.game_result_string, 'O')
                    isGameFinished = true
                } else if (fieldOfGame[i + 3] == 'X') {
                    resultView.text = getString(R.string.game_result_string, 'X')
                    isGameFinished = true
                }
            }
        }
        if (fieldOfGame[2] == fieldOfGame[4] && fieldOfGame[4] == fieldOfGame[6]) {
            if (fieldOfGame[4] == 'O') {
                resultView.text = getString(R.string.game_result_string, 'O')
                isGameFinished = true
            } else if (fieldOfGame[4] == 'X') {
                resultView.text = getString(R.string.game_result_string, 'X')
                isGameFinished = true
            }
        }
        else if (fieldOfGame[0] == fieldOfGame[4] && fieldOfGame[4] == fieldOfGame[8]) {
            if (fieldOfGame[8] == 'O') {
                resultView.text = getString(R.string.game_result_string, 'O')
                isGameFinished = true
            } else if (fieldOfGame[8] == 'X') {
                resultView.text = getString(R.string.game_result_string, 'X')
                isGameFinished = true
            }
        }

        else if(!fieldOfGame.contains(null) && !isGameFinished){
            resultView.text = "Draw"
            isGameFinished = true
        }
    }
}