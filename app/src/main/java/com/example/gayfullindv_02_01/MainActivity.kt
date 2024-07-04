package com.example.gayfullindv_02_01

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var entry: Button
    lateinit var PREF:SharedPreferences
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById(R.id.login)
        password = findViewById(R.id.password)
        entry = findViewById(R.id.entry)
        PREF = getPreferences(MODE_PRIVATE)
    }

    fun Entry(view: View) {
        if(login.text.toString() != "" && password.text.toString()!=""){
            if(PREF.getString("login","")=="" || PREF.getString("password","")==""){
                PREF.edit().putString("login",login.text.toString()).apply()
                PREF.edit().putString("password",password.text.toString()).apply()
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
            else{
                if(PREF.getString("login","")== login.text.toString() && PREF.getString("password","")==password.text.toString()){
                    val intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }
                else{
                    var snack = Snackbar.make(view,"Login or password was wrong",Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        else{
            var snack = Snackbar.make(view,"Error login or password was null",Snackbar.LENGTH_SHORT).show()
        }

    }
}