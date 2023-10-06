package com.example.differentplanethumanweightcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val secondActbutton = findViewById<Button>(R.id.startButton)
        secondActbutton.setOnClickListener(){
            val Intent = Intent(this,MainActivity2::class.java)
            startActivity(Intent)
            Toast.makeText(
                applicationContext,"Great!!", Toast.LENGTH_LONG
            )
                .show()
        }

    }
    private fun setUpclickListener(){

    }
}