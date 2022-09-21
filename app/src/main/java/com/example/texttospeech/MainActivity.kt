package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1=findViewById<Button>(R.id.speakButton)
        var e1=findViewById<EditText>(R.id.inputText)

        b1.setOnClickListener {
            tts= TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
                if(it==TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.UK)
                    tts.setSpeechRate(1.0f)
                    tts.speak(e1.text.toString(), TextToSpeech.QUEUE_FLUSH, null,"")

                }
            })
        }
    }
}