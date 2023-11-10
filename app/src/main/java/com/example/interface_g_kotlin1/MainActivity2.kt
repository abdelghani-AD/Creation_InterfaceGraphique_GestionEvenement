package com.example.interface_g_kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val input = findViewById<EditText>(R.id.input)
        val textView = findViewById<TextView>(R.id.textView2)
        val activity2 = findViewById<ConstraintLayout>(R.id.activity2)

        input.addTextChangedListener(object :TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textView.setText("Text : "+ p0)
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        input.setOnFocusChangeListener(object : OnFocusChangeListener{
            override fun onFocusChange(p0: View?, p1: Boolean) {
                if (p1){
                    Toast.makeText(this@MainActivity2,"Text As Focus",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@MainActivity2,"text lost Focus",Toast.LENGTH_SHORT).show()
                }
            }
        })
        input.setOnKeyListener(View.OnKeyListener{v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                Toast.makeText(this@MainActivity2,"Key Entre",Toast.LENGTH_SHORT).show()
                return@OnKeyListener true
            }
            false
        })
        activity2.setOnTouchListener(object :OnSwipTouchListener(this@MainActivity2){
            override fun onSwipRight(): Boolean {
                val i = Intent(this@MainActivity2,MainActivity::class.java)
                startActivity(i)
                return true
            }

            override fun onSwipLeft(): Boolean {
                val i = Intent(this@MainActivity2,MainActivity3::class.java)
                startActivity(i)
                return true
            }
        })
    }
}