package com.example.linkedtriangleconcentricarcview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.triangleconcentricarcview.TriangleConcentricArcView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TriangleConcentricArcView.create(this)
        fullscreen()
    }
}

fun MainActivity.fullscreen() {
    supportActionBar?.hide()
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}