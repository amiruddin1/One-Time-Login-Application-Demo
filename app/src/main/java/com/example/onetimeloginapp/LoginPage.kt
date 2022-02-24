package com.example.onetimeloginapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        var uname = findViewById<EditText>(R.id.txtuname)
        var pass= findViewById<EditText>(R.id.txtpass)
        var button= findViewById<Button>(R.id.btnlogin)
        button.setOnClickListener {
            if((uname.text.toString()=="") || (pass.text.toString()==""))
            {
                Toast.makeText(this,"UserName Or Password Not Must Be Empty",Toast.LENGTH_LONG).show()
            }
            else
            {
                if((uname.text.toString()=="Admin") || (pass.text.toString()=="Admin"))
                {
                    var preference:SharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
                    var prefeditor = preference.edit()
                    prefeditor.putString("UserName",uname.text.toString())
                    prefeditor.commit()
                    var intent = Intent(this,HomePage::class.java)
                    startActivity(intent)
                    finish()

                }

            }
        }

    }
}