package com.example.drawing


import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.graphics.scale


private val FROM_COLOR = intArrayOf(49, 179, 110)
private const val THRESHOLD = 3

class PetalView : androidx.appcompat.widget.AppCompatTextView {
    private var petalBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ellipse_removebg_preview)



    private var rot: Float = 0.0f

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    override fun setRotation(rotation: Float) {
        rot = rotation
    }



    override fun onDraw(canvas: Canvas?) {
        val p = Paint()
        val p1=Paint()
        p.color = Color.RED
        p.strokeWidth=10f
        p.textSize = 50f
        petalBitmap = petalBitmap.scale(width, height)
        petalBitmap = rotateBitmap(petalBitmap, rot)



        canvas?.drawBitmap(petalBitmap, 0f, 0f, p)
        
        when (rot) {
            0f -> canvas?.drawText("150", ((width / 2).toFloat() - 60), (height / 2) + 35.toFloat(), p)
            90f -> canvas?.drawText("180", ((width / 2).toFloat() - 70), (height / 2) + 20.toFloat(), p)
            180f -> canvas?.drawText("250", ((width / 2).toFloat() - 30), (height / 2).toFloat(), p)
            else -> canvas?.drawText("90", ((width / 2).toFloat() - 20), (height / 2) + 35.toFloat(), p)
        }
    }


    private fun rotateBitmap(original: Bitmap, degrees: Float): Bitmap {
        val matrix = Matrix()
        matrix.preRotate(degrees)
        val rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.width, original.height, matrix, true)
        original.recycle()
        return rotatedBitmap
    }

    private fun match(pixel: Int): Boolean {
        //There may be a better way to match, but I wanted to do a comparison ignoring
        //transparency, so I couldn't just do a direct integer compare.
        return Math.abs(Color.red(pixel) - FROM_COLOR[0]) < THRESHOLD && Math.abs(Color.green(pixel) - FROM_COLOR[1]) < THRESHOLD && Math.abs(Color.blue(pixel) - FROM_COLOR[2]) < THRESHOLD
    }

}


