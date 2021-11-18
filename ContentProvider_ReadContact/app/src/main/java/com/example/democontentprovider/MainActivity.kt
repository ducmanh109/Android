package com.example.democontentprovider

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    //4-khai báo những trường dữ liệu cần truy xuất trong danh bạ,toTypeArray để chuyển thành mảng
    var cols = listOf<String>(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER,
                            ContactsContract.CommonDataKinds.Phone._ID).toTypedArray()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1-yêu cầu quyền đọc danh bạ
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,Array(1){Manifest.permission.READ_CONTACTS},100)
        }
        else{
            readContact()
        }
    }
        //2-nếu quyền đọc danh bạ đc chấp thuận thì gọi hàm readContact
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            readContact()
        }
    }
    //3-đọc danh bạ
    private fun readContact() {
        val listV = findViewById<ListView>(R.id.listView1)
        var from = listOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER).toTypedArray()
        var to = intArrayOf(android.R.id.text1, android.R.id.text2)
        //SELECT Name, Phone FROM Phone
        var result = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,cols,
            null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        var adapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,result,from,to,0)
        listV.adapter = adapter
    }
}