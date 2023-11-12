package com.example.interface_g_kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val villes = arrayOf("Rabat","Casa","Maknes","Safi","Sala")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,villes)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinnerResult = findViewById<TextView>(R.id.spinnerText)

        val activity3 = findViewById<ConstraintLayout>(R.id.activity3)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerResult.text = villes[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        activity3.setOnTouchListener(object : OnSwipTouchListener(this@MainActivity3){
            override fun onSwipRight(): Boolean {
                val i = Intent(this@MainActivity3,MainActivity2::class.java)
                startActivity(i)
                return true
            }

            override fun onSwipLeft(): Boolean {
                val i = Intent(this@MainActivity3,MainActivity4::class.java)
                startActivity(i)
                return true
            }
        })
    }
}