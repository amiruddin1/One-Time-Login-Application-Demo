package com.example.onetimeloginapp

import android.content.ClipData
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        var textview = findViewById<TextView>(R.id.txtgreet)
        var preference:SharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        var str = preference.getString("UserName","tt")
        textview.setText("Welcome Dear User "+ str)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       // Toast.makeText(applicationContext,"TT",Toast.LENGTH_LONG).show()
        var item1= item.itemId
        if(item1==R.id.logout)
        {
            var preference:SharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
            var prefeditor = preference.edit()
            prefeditor.clear()
            prefeditor.commit()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            //Commit
            //Intend
        }
        return super.onOptionsItemSelected(item)
    }

}