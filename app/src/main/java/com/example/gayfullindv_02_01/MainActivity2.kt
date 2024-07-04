package com.example.gayfullindv_02_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import kotlin.math.PI

class MainActivity2 : AppCompatActivity() {
    lateinit var fig: Spinner
    lateinit var dannie: EditText
    lateinit var math: Button
    lateinit var img: ImageView
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        fig = findViewById(R.id.fig)
        dannie = findViewById(R.id.dannie)
        math = findViewById(R.id.math)
        img = findViewById(R.id.img)
        var figurs = listOf<String>("Круг","Треугольник")
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,figurs)
        fig.adapter = adapter
        fig.onItemSelectedListener.run {
            Log.d("",fig.selectedItem.toString())
            if(fig.selectedItem == "Круг"){
                img.setImageResource(R.drawable.circle)
            }
            else if(fig.selectedItem == "Треугольник"){
                img.setImageResource(R.drawable.treugolnik)
            }

        }
    }

    fun Math(view: View) {
        if(dannie.text.toString()!=""){
            if(fig.selectedItem == "Круг"){
                var R = dannie.text.toString().toDouble()/(2* PI)
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("rez", R)
                intent.putExtra("figura",fig.selectedItem.toString())
                startActivity(intent)
            }
            else if(fig.selectedItem == "Треугольник"){
                var P = dannie.text.toString().toDouble()*2+dannie.text.toString().toDouble()
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("rez", P)
                intent.putExtra("figura",fig.selectedItem.toString())
                startActivity(intent)
            }
        }
    }
}