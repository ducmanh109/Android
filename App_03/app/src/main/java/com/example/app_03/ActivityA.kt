package com.example.app_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        val buttonB = findViewById<Button>(R.id.btnB)
        val editText = findViewById<EditText>(R.id.edt1);
        buttonB.setOnClickListener{
            val value = editText.text.toString()
            val intent = Intent(this@ActivityA, ActivityB::class.java)
            intent.putExtra("value",value)
            startActivity(intent)
        }
    }
}