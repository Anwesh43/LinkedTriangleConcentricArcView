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
val deg : Float = 360f
val rot : Float = 60f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawTriangleArcLine(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val r : Float = Math.min(w, h) / sizeFactor
    save()
    translate(w / 2, h / 2)
    rotate(deg * sf.divideScale(arcs + 1, parts))
    for (j in 0..1) {
        save()
        rotate(rot * (1f - 2 * j))
        drawLine(0f, 0f, r * sf.divideScale(0, parts), 0f, paint)
        restore()
    }
    for (j in 1..arcs) {
        val currRot : Float = rot * sf.divideScale(j, parts)
        val currR : Float = j * (r / arcs)
        save()
        drawArc(RectF(-currR, -currR, currR, currR), -currRot, currRot * 2, false, paint)
        restore()
    }
    restore()
}

fun Canvas.drawTCANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.style = Paint.Style.STROKE
    drawTriangleArcLine(scale, w, h, paint)
}

class TriangleConcentricArcView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}