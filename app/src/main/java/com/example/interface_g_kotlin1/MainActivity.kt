package com.example.interface_g_kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.OnSwipe
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activity1 = findViewById<ConstraintLayout>(R.id.activity)
        val textAfiicher = findViewById<TextView>(R.id.textAfficher)
        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener{
            Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
            textAfiicher.text= "Button submit On Long click"
            true
        }
        activity1.setOnTouchListener(object : OnSwipTouchListener(this@MainActivity){
            override fun onSwipLeft(): Boolean {
                val i= Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(i)
                return true
            }
        })
    }
}