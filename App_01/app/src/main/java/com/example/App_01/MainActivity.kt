package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.edt1);
        val textView = findViewById<TextView>(R.id.tv1);
        val button = findViewById<Button>(R.id.btn1);
        button.setOnClickListener(View.OnClickListener {
            textView.text = editText.text;
        })
    }
}