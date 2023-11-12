package com.example.interface_g_kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val actionBar = supportActionBar
        actionBar!!.hide()
        setContentView(R.layout.activity_main4)
        val image = findViewById<ImageView>(R.id.image)
        val activity4 = findViewById<RelativeLayout>(R.id.activity4)
        var linstener = View.OnTouchListener(function = {view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }
            true
        })

        image.setOnTouchListener(linstener)
        activity4.setOnTouchListener(object : OnSwipTouchListener(this@MainActivity4) {
            override fun onSwipRight(): Boolean {
                val i = Intent(this@MainActivity4, MainActivity3::class.java)
                startActivity(i)
                return true;
            }
            override fun onSwipLeft(): Boolean {
                val i = Intent(this@MainActivity4,MainActivity5::class.java )
                startActivity(i)
                return true;
            }
        })

    }
}