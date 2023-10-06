package com.example.differentplanethumanweightcalculator

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spinner = findViewById<Spinner>(R.id.planets_spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        var planet = 0.00

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                val selectedPlanet = parent?.getItemAtPosition(position).toString()
                if(selectedPlanet == "Mercury") planet = 0.38
                if(selectedPlanet == "Venus") planet = 0.91
                if(selectedPlanet == "Earth") planet = 1.0
                if(selectedPlanet == "Mars") planet = 0.38
                if(selectedPlanet == "Jupiter") planet = 2.34
                if(selectedPlanet == "Saturn") planet = 1.06
                if(selectedPlanet == "Uranus") planet = 0.92
                if(selectedPlanet == "Neptune") planet = 1.19
                if (selectedPlanet == "Sun") {
                    planet = 27.01
                    Toast.makeText(applicationContext,"Fun fact the Sun is not a planet!",Toast.LENGTH_LONG).show()}

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected (optional)
            }
        }



        val calculateButton = findViewById<Button>(R.id.calculate_button)
        calculateButton.setOnClickListener() {
            showResult(calculate(planet))
        }

    }

    private fun calculate(planet:Double): Double {
        val userWeightText = findViewById<EditText>(R.id.weight_Input)
        val userWeight = userWeightText.text.toString().toDouble()

        return (userWeight * planet)


    }

    private fun showResult(weight:Double) {

        val weightText = findViewById<TextView>(R.id.result)
        val resultTex = ("%.2f".format(weight))
        val lbs = " Lbs"

        weightText.text = resultTex + lbs

    }




}



