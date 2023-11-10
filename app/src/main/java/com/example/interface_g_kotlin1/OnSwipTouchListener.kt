package com.example.interface_g_kotlin1

import android.content.Context
import android.gesture.GestureOverlayView.OnGestureListener
import android.view.FrameMetrics
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

open class OnSwipTouchListener(val context:Context?):View.OnTouchListener {
    companion object{
        private const val swipThreshold = 200
        private const val swipVelocityThreshod = 100
    }
    private val gestureDectector = GestureDetector(context,GestureListener())
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return gestureDectector.onTouchEvent(event)
    }

    open fun onSwipRight():Boolean{return false}
    open fun onSwipLeft():Boolean{return false}
    open fun onSwipUp():Boolean{return false}
    open fun onSwipDown():Boolean{return false}

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            try {
                val diffY = e2.y - e1!!.y
                val diffX = e2.x - e1.x
                if (abs(diffX) > abs(diffY)) {
                    if (abs(diffX) > abs(diffY)) {
                        if (abs(diffX) > swipThreshold && abs(velocityX) > swipVelocityThreshod) {
                            return when {
                                diffX > 0 -> onSwipRight()
                                else -> onSwipLeft()
                            }
                        }
                    }
                } else if (abs(diffY) > swipThreshold && abs(velocityY) > swipVelocityThreshod) {
                    return when {
                        diffY > 0 -> onSwipDown()
                        else -> onSwipUp()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }
    }
}