package com.example.ap2_dev_mobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ResultadoFormulario : AppCompatActivity() {
    private lateinit var tvPontuacao: TextView
    private lateinit var tvNivelConhecimento: TextView
    private lateinit var btnAbrirYouTube: ImageButton
    private lateinit var btnResetarForm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_formulario)

        tvPontuacao = findViewById(R.id.tvPontuacao)
        tvNivelConhecimento = findViewById(R.id.tvNivelConhecimento)
        btnAbrirYouTube = findViewById(R.id.btnAbrirYouTube)
        btnResetarForm = findViewById(R.id.btnResetarForm)

        val pontuacao = SharedData.totalScore

        tvPontuacao.text = "Pontuação Final: $pontuacao"

        tvNivelConhecimento.text = when {
            pontuacao <= 10 -> "Seu nível de conhecimento é baixo... Aqui está um vídeo para te ajudar."
            pontuacao <= 20 -> "Seu nível de conhecimento é moderado. Aqui está um vídeo para melhorar seus conhecimentos."
            else -> "Seu nível de conhecimento é alto!!! Aqui está um vídeo para ampliar seus horizontes."
        }

        val videoId = when {
            pontuacao <= 10 -> "_YVbIcLgIBA"
            pontuacao <= 20 -> "YXic9ndGqb4"
            else -> "Buw-HiJSzzc"
        }

        val videoUrl = "https://www.youtube.com/watch?v=$videoId"

        btnAbrirYouTube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
            startActivity(intent)
        }

        btnResetarForm.setOnClickListener {
            SharedData.totalScore = 0
            SharedData.lastPoints = 0
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
