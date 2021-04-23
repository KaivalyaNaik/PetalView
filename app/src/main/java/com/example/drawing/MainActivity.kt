package com.example.drawing

import android.content.res.ColorStateList
import android.graphics.*
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionManager
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.transition.MaterialFadeThrough


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fadeIn: Animation = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this

        fadeIn.duration = 2000

        val rotateAnimation =RotateAnimation(315f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        rotateAnimation.duration=1000
        rotateAnimation.interpolator=LinearInterpolator()

        val animation = AnimationSet(false) //change to false


        animation.addAnimation(fadeIn)
        animation.addAnimation(rotateAnimation)

        val view:ConstraintLayout=findViewById(R.id.flower)

        val svgPetal:SvgPetal =findViewById(R.id.svgPetal)

        svgPetal.backgroundTintList= ColorStateList.valueOf(ContextCompat.getColor(this,R.color.red))

        val svgPetal315:SvgPetal =findViewById(R.id.petal315)

        svgPetal315.text="200"
        svgPetal315.backgroundTintList=ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange))

        view.animation=animation



    }
}


