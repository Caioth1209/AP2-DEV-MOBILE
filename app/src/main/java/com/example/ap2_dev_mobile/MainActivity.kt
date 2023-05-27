package com.example.ap2_dev_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    private lateinit var answerRg: RadioGroup
    private lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        answerRg = findViewById(R.id.answerRg)
        nextBtn = findViewById(R.id.nextBtn)

        nextBtn.setOnClickListener {
            val selectedId = answerRg.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)

            selectedRadioButton?.let {
                val answer = it.text.toString();
                val intent = Intent(this, Pergunta2::class.java);

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