package com.example.triangleconcentricarcview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val colors : Array<Int> = arrayOf(
    "#F44336",
    "#4CAF50",
    "#673AB7",
    "#4CAF50",
    "#2196F3"
).map {
    Color.parseColor(it)
}.toTypedArray()
val arcs : Int = 3
val parts : Int = arcs + 2
val scGap : Float = 0.02f / parts
val strokeFactor : Float = 90f
val sizeFactor : Float = 4.5f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
