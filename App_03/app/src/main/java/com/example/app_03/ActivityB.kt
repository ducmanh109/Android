package com.example.app_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val intent = Intent(this, ActivityA::class.java)
        val getValue = intent.getStringExtra("value")
        val textView = findViewById<TextView>(R.id.tv1)
        textView.text = "${getValue}"
    }
}