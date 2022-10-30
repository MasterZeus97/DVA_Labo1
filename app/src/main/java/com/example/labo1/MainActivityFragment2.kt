package com.example.labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivityFragment2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment2)
        val backButton = findViewById<Button>(R.id.button_back)
        val closeButton = findViewById<Button>(R.id.button_close)
        val nextButton = findViewById<Button>(R.id.button_next)

        closeButton.setOnClickListener{
            finish()
        }

        nextButton.setOnClickListener{
            val tmp = supportFragmentManager.backStackEntryCount + 1
            supportFragmentManager.beginTransaction().replace(R.id.frag_part3, CounterFragPart3.newInstance(tmp)).addToBackStack(null).commit()
        }

        backButton.setOnClickListener{
            if(supportFragmentManager.backStackEntryCount <= 0)
                finish()

            supportFragmentManager.popBackStack()
        }
    }
}