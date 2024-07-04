package com.example.gayfullindv_02_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity3 : AppCompatActivity() {
    lateinit var figura: EditText
    lateinit var rez: EditText
    lateinit var button: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        button = findViewById(R.id.back)
        figura = findViewById(R.id.figura)
        rez = findViewById(R.id.rezultat)
        rez.setText(intent.getDoubleExtra("rez",0.00).toString())
        figura.setText(intent.getStringExtra("figura"))
    }

    fun Entry(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}