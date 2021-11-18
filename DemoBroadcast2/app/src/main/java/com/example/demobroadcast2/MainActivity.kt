package com.example.demobroadcast2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val MY_ACTION: String = "Action"
    val MY_TEXT: String = "Key de gui broadcast"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val broadcastReceiver = object : BroadcastReceiver()
    {
        //2-nhan broadcast va hien thi len textview
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                if (MY_ACTION.equals(intent.action)){
                    val text: String? = intent.getStringExtra(MY_TEXT)
                    val textView1 = findViewById<TextView>(R.id.tv1)
                    textView1.setText(text)
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(MY_ACTION)
        registerReceiver(broadcastReceiver,intentFilter)
    }
    //4-unregister broadcast
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }
}