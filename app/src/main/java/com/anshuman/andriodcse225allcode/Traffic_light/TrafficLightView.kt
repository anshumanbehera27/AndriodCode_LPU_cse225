package com.anshuman.andriodcse225allcode.Traffic_light

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TrafficLightView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var lightColor: Int = Color.RED
    private val redColor = Color.RED
    private val yellowColor = Color.YELLOW
    private val greenColor = Color.GREEN

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas) // Call super.onDraw() to draw the background

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val radius = width / 4f

        // Draw red light
        paint.color = if (lightColor == redColor) redColor else Color.GRAY
        canvas.drawCircle(width / 2f, height / 6f, radius, paint)

        // Draw yellow light
        paint.color = if (lightColor == yellowColor) yellowColor else Color.GRAY
        canvas.drawCircle(width / 2f, height / 2f, radius, paint)

        // Draw green light
        paint.color = if (lightColor == greenColor) greenColor else Color.GRAY
        canvas.drawCircle(width / 2f, height * 5f / 6f, radius, paint)
        }


fun setLightColor(color: Int) {
    lightColor = color
    invalidate()
}
}

