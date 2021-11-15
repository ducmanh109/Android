package com.example.app_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val buttonA = findViewById<Button>(R.id.btnA);
        buttonA.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivityA::class.java);
            startActivity(intent);
        })
    }
}