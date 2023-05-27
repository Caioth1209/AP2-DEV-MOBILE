package com.example.ap2_dev_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Pergunta3 : AppCompatActivity() {

    private lateinit var answerRg: RadioGroup
    private lateinit var nextBtn: Button
    private lateinit var backBtn: Button
    private lateinit var pointsTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta2)

        backBtn = findViewById(R.id.backBtn)
        nextBtn = findViewById(R.id.nextBtn)
        answerRg = findViewById(R.id.answerRg)
        pointsTv = findViewById(R.id.pointsTv)

        pointsTv.text = "Sua pontuação: " + SharedData.totalScore;

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        nextBtn.setOnClickListener {
            val selectedId = answerRg.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)

            selectedRadioButton?.let {
                val answer = it.text.toString();
                val intent = Intent(this, Pergunta4::class.java);

                when (answer) {
                    "Sim" -> {
                        SharedData.totalScore += 10;
                    }
                    "Não" -> {
                        SharedData.totalScore += 2;
                    }
                }

                startActivity(intent);
            }
        }

    }
}