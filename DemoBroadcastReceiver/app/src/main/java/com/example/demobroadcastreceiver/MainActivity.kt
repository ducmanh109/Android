package com.example.demobroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val MY_ACTION: String = "Action"
    val MY_TEXT: String = "Key de gui broadcast"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btnSendBroadcast)
        btn1.setOnClickListener() {
            Toast.makeText(this, "Gui broadcast di",Toast.LENGTH_LONG).show()
            clickSendBroadcast()
        }
    }
    //1-click button de gui broadcast
    private fun clickSendBroadcast() {
        val intent = Intent()
        intent.setAction(MY_ACTION)
        intent.putExtra(MY_TEXT, "Da nhan duoc broadcast")
        sendBroadcast(intent)
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
    //3-register broadcast
    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(MY_ACTION)
        registerReceiver(broadcastReceiver,intentFilter)
    }
    //4-unregister broadcast
    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}
