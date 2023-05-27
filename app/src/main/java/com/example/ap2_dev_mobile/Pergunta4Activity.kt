package com.example.ap2_dev_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Pergunta4Activity : AppCompatActivity() {

    private lateinit var answerRg: RadioGroup
    private lateinit var nextBtn: Button
    private lateinit var backBtn: Button
    private lateinit var pointsTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta4)

        backBtn = findViewById(R.id.backBtn)
        nextBtn = findViewById(R.id.nextBtn)
        answerRg = findViewById(R.id.answerRg)
        pointsTv = findViewById(R.id.pointsTv)

        pointsTv.text = "Sua pontuação: " + SharedData.totalScore;

        backBtn.setOnClickListener {
            SharedData.totalScore -= SharedData.lastPoints;
            SharedData.lastPoints = 0;
            val intent = Intent(this, Pergunta3Activity::class.java);
            startActivity(intent);
        }

        nextBtn.setOnClickListener {
            val selectedId = answerRg.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)

            if (selectedId != -1) {
                val answer = selectedRadioButton.text.toString()
                val intent = Intent(this, ResultadoFormulario::class.java)

                when (answer) {
                    "Sim" -> {
                        SharedData.totalScore += 10
                        SharedData.lastPoints = 10
                    }
                    "Não" -> {
                        SharedData.totalScore += 2
                        SharedData.lastPoints = 2
                    }
                }

                startActivity(intent)
            } else {
                showErrorFragment("Por favor, selecione uma opção antes de prosseguir.")
            }
        }
    }

    private fun showErrorFragment(errorMessage: String) {
        val fragment = MessageFragment.newInstance(errorMessage)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}