package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(){

    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1=findViewById<Button>(R.id.speakButton)
        var e1=findViewById<EditText>(R.id.inputText)

        tts= TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
            if (it == TextToSpeech.SUCCESS) {
                val result = tts.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "Language Not Supported")
                }
                else
                {
                    tts.setSpeechRate(1.0f)
                    b1.isEnabled = true
                }
            }
            else
            {
                Log.e("TTS", "Initialization Failed")
            }
        })
        b1.setOnClickListener {
                speakOut(e1.text.toString());
        }

    }

    fun speakOut(text:String){
        tts.speak(text, TextToSpeech.QUEUE_ADD, null,null)
    }
}

