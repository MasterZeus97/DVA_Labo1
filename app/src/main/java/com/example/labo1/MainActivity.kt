package com.example.labo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var shownText: TextView


    private val getName = registerForActivityResult(PickNameContract()){
        if(it == null){
            shownText.text = INITIAL_MESSAGE
        }else{
            shownText.text = START_MESSAGE + it
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        val button = findViewById<Button>(R.id.validation_button)
        shownText = findViewById<TextView>(R.id.information_text)
        button.setOnClickListener{
            getName.launch(null)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(TEXT_KEY, shownText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        shownText.text = savedInstanceState.getString(TEXT_KEY)
    }

    companion object {
        const val TEXT_KEY = "TEXT_KEY" //Key to save/read value from bundle

        const val START_MESSAGE = "Benvenue "

        const val INITIAL_MESSAGE = "Bienvenue, veuillez entrer votre nom"
    }
}