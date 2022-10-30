package com.example.labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class MyActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity_layout)

        val button = findViewById<Button>(R.id.save_button)
        val myText = findViewById(R.id.edit_text1) as EditText

        button.setOnClickListener{
            val fieldValue = myText.text.toString()

            if(!TextUtils.isEmpty(fieldValue)){
                val data = Intent()
                data.putExtra(ASK_FOR_NAME_RESULT_KEY, fieldValue)
                setResult(RESULT_OK, data)
                finish()
            }
        }
    }

    companion object{
        val ASK_FOR_NAME_RESULT_KEY= "NAME_KEY"
    }
}
