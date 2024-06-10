package com.example.weatherupdateapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeTo
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        class MainActivity : AppCompatActivity() {

            private lateinit var mondayTempInput: EditText
            private lateinit var tuesdayTempInput: EditText
            private lateinit var wednesdayTempInput: EditText
            private lateinit var thursdayTempInput: EditText
            private lateinit var fridayTempInput: EditText
            private lateinit var saturdayTempInput: EditText
            private lateinit var sundayTempInput: EditText
            private lateinit var btnAdd: Button
            private lateinit var btnClear: Button
            private lateinit var btnNextPg: Button
            private lateinit var txtResults: TextView

            private val temperatures = IntArray(7)

            @SuppressLint("MissingInflatedId")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                mondayTempInput = findViewById(R.id.inputValue)
                tuesdayTempInput = findViewById(R.id.inputValue2)
                wednesdayTempInput = findViewById(R.id.inputValue3)
                thursdayTempInput = findViewById(R.id.inputValue4)
                fridayTempInput = findViewById(R.id.inputValue5)
                saturdayTempInput = findViewById(R.id.inputValue6)
                sundayTempInput = findViewById(R.id.inputValue7)
                btnAdd = findViewById(R.id.btnAdd)
                btnClear = findViewById(R.id.btnClear)
                btnNextPg = findViewById(R.id.btnNextPg)
                txtResults = findViewById(R.id.txtResults)

                btnAdd.setOnClickListener { // The whole point for this is to add all the values from the week so that we can get an average
                    if (validateInputs()) {
                        temperatures[0] = mondayTempInput.text.toString().toInt()
                        temperatures[1] = tuesdayTempInput.text.toString().toInt()
                        temperatures[2] = wednesdayTempInput.text.toString().toInt()
                        temperatures[3] = thursdayTempInput.text.toString().toInt()
                        temperatures[4] = fridayTempInput.text.toString().toInt()
                        temperatures[5] = saturdayTempInput.text.toString().toInt()
                        temperatures[6] = sundayTempInput.text.toString().toInt()

                        val average = calculateAverage(temperatures)// You take the total of all the values from th week than you divide it by the size of the array
                        txtResults.text = "Average Temperature: $average"
                    } else {
                        txtResults.text = "Please enter temperatures for all days"
                    }
                }

                btnClear.setOnClickListener {
                    for (i in temperatures.indices) {
                        temperatures[i] = 0
                    }
                    mondayTempInput.text.clear()
                    tuesdayTempInput.text.clear()
                    wednesdayTempInput.text.clear()
                    thursdayTempInput.text.clear()
                    fridayTempInput.text.clear()
                    saturdayTempInput.text.clear()
                    sundayTempInput.text.clear()
                    txtResults.text = ""
                }

                btnNextPg.setOnClickListener {
                    val intent = Intent(this, com.example.weatherupdateapp.DetailedVSActivity::class.java)
                    startActivity(intent)
                }
            }

            private fun validateInputs(): Boolean {
                return mondayTempInput.text.isNotEmpty() &&
                        tuesdayTempInput.text.isNotEmpty() &&
                        wednesdayTempInput.text.isNotEmpty() &&
                        thursdayTempInput.text.isNotEmpty() &&
                        fridayTempInput.text.isNotEmpty() &&
                        saturdayTempInput.text.isNotEmpty() &&
                        sundayTempInput.text.isNotEmpty()
            }

            private fun calculateAverage(values: IntArray): Double {
                val sum = values.sum()
                return sum / values.size.toDouble()
            }
        }




    }
        }












