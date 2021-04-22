package com.example.drawing

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet



class SvgPetal :androidx.appcompat.widget.AppCompatTextView {


    private var rot:Float=0f

    private var paint=Paint()

    constructor(context: Context, attrs: AttributeSet?):super(context, attrs)

    override fun setRotation(rotation: Float) {
        rot=rotation
    }


    override fun onDraw(canvas: Canvas?) {
        paint.color= Color.WHITE
        paint.textSize=50f
        canvas?.drawText(text.toString(), width / 2.toFloat()-40 , height / 2.toFloat()+20, paint)

    }





}