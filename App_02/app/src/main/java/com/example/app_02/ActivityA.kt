package com.example.app_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        val buttonB = findViewById<Button>(R.id.btnB);
        buttonB.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivityB::class.java);
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP;
            startActivity(intent);
        })
    }
}