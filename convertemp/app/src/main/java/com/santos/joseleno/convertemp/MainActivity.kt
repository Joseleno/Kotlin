package com.santos.joseleno.convertemp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {


    lateinit var editText: EditText
    lateinit var celciuosRadio: RadioButton
    lateinit var fahrenheitRadio: RadioButton
    lateinit var convertirButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.valorTemp)
        celciuosRadio = findViewById<RadioButton>(R.id.celciusRadio)
        fahrenheitRadio = findViewById<RadioButton>(R.id.fahrenheitRadio)
        convertirButton = findViewById<Button>(R.id.convertButton)
        convertirButton.setOnClickListener{convertir(it)}

    }

    fun convertir(view: View){
        var temp: Double = editText.text.toString().toDouble()
        if (celciuosRadio.isChecked){

            temp = (temp-32)*5/9

        }else if (fahrenheitRadio.isChecked){

            temp = temp * 9/5 + 32

        }

        editText.setText(temp.toString())
    }
}
