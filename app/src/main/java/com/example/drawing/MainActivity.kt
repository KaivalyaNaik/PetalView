package com.example.drawing

import android.graphics.*
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionManager
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.transition.MaterialFadeThrough


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fadeIn: Animation = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this

        fadeIn.duration = 2000

        val rotateAnimation =RotateAnimation(-180f,-360f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,1.0f)
        rotateAnimation.duration=1500
        rotateAnimation.interpolator=DecelerateInterpolator()

        val animation = AnimationSet(false) //change to false

        animation.addAnimation(fadeIn)
        animation.addAnimation(rotateAnimation)

        val view:ConstraintLayout=findViewById(R.id.flower)

        val svgPetal:SvgPetal =findViewById(R.id.svgPetal)
        val svgPetal90:SvgPetal =findViewById(R.id.svgPetal2)
        val svgPetal180:SvgPetal =findViewById(R.id.svgPetal3)
        val svgPetal270:SvgPetal =findViewById(R.id.svgPetal4)



        svgPetal.animation=animation
        svgPetal90.animation=animation
        svgPetal180.animation=animation
        svgPetal270.animation=animation




    }
}


