package com.example.hoka.equationsolver

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val solveButton = findViewById<Button>(R.id.solveButton)
        val bText = findViewById<TextView>(R.id.bTitle)
        solveButton.setOnClickListener {
            this.buttonClickListener()
        }
    }

    private fun buttonClickListener() {
        val aValView = findViewById<EditText>(R.id.aVal)
        val aValue = aValView.text.toString().toIntOrNull()
        val bValView = findViewById<EditText>(R.id.bVal)
        val bValue = bValView.text.toString().toIntOrNull()
        val cValView = findViewById<EditText>(R.id.cVal)
        val cValue = cValView.text.toString().toIntOrNull()
        val dText = findViewById<TextView>(R.id.dTextResult)
        dText.text = null
        val x1Text = findViewById<TextView>(R.id.x1TextResult)
        x1Text.text = null
        val x2Text = findViewById<TextView>(R.id.x2TextResult)
        x2Text.text = null
        x2Text.setText("").toString()
        var x1Value = 0
        var x2Value = 0

        if ( aValue == 0) {
            val toast: Toast = Toast.makeText(this, R.string.aNotNull, Toast.LENGTH_LONG)
            toast.show()
            return
        }

        if ( aValue == null || bValue == null || cValue == null) {
            val toast: Toast = Toast.makeText(this, R.string.errorField, Toast.LENGTH_LONG)
            toast.show()
        }

        if ( aValue != 0 && bValue != null && bValue != null) {


            val discriminant = bValue * bValue - 4 * aValue!! * cValue!!
            Log.d("mLog: ", "D = " + discriminant )

            if (discriminant < 0) {
                dText.text = discriminant.toString()
                val toast: Toast = Toast.makeText(this, R.string.squareRootNot, Toast.LENGTH_LONG)
                toast.show()
            }

            if (discriminant == 0) {
                x1Value = (-1 * bValue) / (2 * aValue)
                Log.d("mLog: ", "D=0, X1 = " + x1Value)
                val toast: Toast = Toast.makeText(this, R.string.squareRootIsOne, Toast.LENGTH_LONG)
                toast.show()
                dText.text = discriminant.toString()
                x1Text.text = x1Value.toString()
            }

            if (discriminant > 0) {
                x1Value = ((-bValue) + kotlin.math.sqrt(discriminant.toDouble())).toInt() / 2*aValue
                x2Value = ((-bValue) - kotlin.math.sqrt(discriminant.toDouble())).toInt() / 2*aValue
                Log.d("mLog: ", "D > 0, X1 =" + x1Value + " X2 = " + x2Value)
                val toast: Toast = Toast.makeText(this, R.string.squareRootIsTwo, Toast.LENGTH_LONG)
                toast.show()
                dText.text = discriminant.toString()
                x1Text.text = x1Value.toString()
                x2Text.text = x2Value.toString()
            }
        }



    }
}
