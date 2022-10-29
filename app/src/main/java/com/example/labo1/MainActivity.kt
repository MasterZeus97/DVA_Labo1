package com.example.labo1

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
        //Log.d("MainActivity", "Mon nom est $it")
        shownText.text = it
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        val button = findViewById<Button>(R.id.validation_button)
        shownText = findViewById<TextView>(R.id.information_text)
        button.setOnClickListener{
            /*val i = Intent(this, MyActivity2::class.java)
            startActivity(i)*/
            val textRecieved = getName.launch(null)


        }
    }
}