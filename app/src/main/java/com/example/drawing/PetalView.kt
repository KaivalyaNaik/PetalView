package com.example.drawing


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.scale


class PetalView : View {
    private var petalBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ellipse_removebg_preview)

    private var rot: Float = 0.0f

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    override fun setRotation(rotation: Float) {
        rot = rotation
    }



    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onDraw(canvas: Canvas?) {
        val p = Paint()
        val p1=Paint()
        val c= context.getColor(R.color.red)
        p.color = c
        p.strokeWidth=10f
        p.textSize = 50f
        petalBitmap = petalBitmap.scale(width, height)
        petalBitmap = rotateBitmap(petalBitmap, rot)
        canvas?.drawBitmap(petalBitmap, 0f, 0f, p1)
        if (rot == 0f)
            canvas?.drawText("150", ((width / 2).toFloat() - 60), (height / 2) + 35.toFloat(), p)
        else if(rot== 90f)
            canvas?.drawText("180", ((width / 2).toFloat() - 70), (height / 2) + 20.toFloat(), p)
        else if(rot ==180f)
            canvas?.drawText("250", ((width / 2).toFloat() - 30), (height / 2) .toFloat(), p)
        else
            canvas?.drawText("90", ((width / 2).toFloat() - 20), (height / 2) + 35.toFloat(), p)
    }


    private fun rotateBitmap(original: Bitmap, degrees: Float): Bitmap {
        val matrix = Matrix()
        matrix.preRotate(degrees)
        val rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.width, original.height, matrix, true)
        original.recycle()
        return rotatedBitmap
    }
}


