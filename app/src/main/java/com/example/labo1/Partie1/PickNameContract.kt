package com.example.labo1

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class PickNameContract : ActivityResultContract<Void?, String?>() {
    override fun createIntent(context: Context, input: Void?) = Intent(context, MyActivity2::class.java)

    override fun parseResult(resultCode: Int, result: Intent?): String? {
        if(resultCode != Activity.RESULT_OK){
            return null
        }else{
            return result?.getStringExtra(MyActivity2.ASK_FOR_NAME_RESULT_KEY)
        }
    }
}
