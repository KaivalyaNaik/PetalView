package com.example.drawing

import android.os.Bundle
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val interpolator=DecelerateInterpolator()
        val linearInterpolator=LinearInterpolator()
        val bounceInterpolator=BounceInterpolator()

        val fadeIn1: Animation = AlphaAnimation(0f, 1f)
        fadeIn1.interpolator = interpolator

        fadeIn1.duration = 4000
        val fadeIn2: Animation = AlphaAnimation(0f, 1f)
        fadeIn2.interpolator = interpolator

        fadeIn2.duration = 1000

        val fadeIn3: Animation = AlphaAnimation(0f, 1f)
        fadeIn3.interpolator = interpolator

        fadeIn3.duration = 2000

        val fadeIn4: Animation = AlphaAnimation(0f, 1f)
        fadeIn4.interpolator = interpolator

        fadeIn4.duration = 2000

        val rotatepetal1 =RotateAnimation(-0f,-360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1.0f)
        rotatepetal1.duration=4000
        rotatepetal1.interpolator=interpolator


        val rotatepetal2 =RotateAnimation(-270f,-360f,Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.5f)
        rotatepetal2.duration=1000
        rotatepetal2.interpolator=interpolator


        val rotatepetal3 =RotateAnimation(-180f,-360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0f)
        rotatepetal3.duration=2000
        rotatepetal3.interpolator=interpolator

        val rotatepetal4 =RotateAnimation(-90f,-360f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.5f)
        rotatepetal4.duration=3000
        rotatepetal4.interpolator=interpolator

        val animationpetal1 = AnimationSet(false) //change to false
        val animationpetal2 =AnimationSet(false)
        val animationpetal3 =AnimationSet(false)
        val animationpetal4 =AnimationSet(false)


        animationpetal1.addAnimation(fadeIn1)
        animationpetal1.addAnimation(rotatepetal1)

        animationpetal2.addAnimation(fadeIn2)
        animationpetal2.addAnimation(rotatepetal2)

        animationpetal3.addAnimation(fadeIn3)
        animationpetal3.addAnimation(rotatepetal3)

        animationpetal4.addAnimation(fadeIn4)
        animationpetal4.addAnimation(rotatepetal4)




        val view:ConstraintLayout=findViewById(R.id.flower)

        val svgPetal:SvgPetal =findViewById(R.id.svgPetal)
        val svgPetal180:SvgPetal =findViewById(R.id.svgPetal2)
        val svgPetal90:SvgPetal =findViewById(R.id.svgPetal3)
        val svgPetal270:SvgPetal =findViewById(R.id.svgPetal4)

        svgPetal.animation=animationpetal1
        svgPetal270.animation=animationpetal2
        svgPetal180.animation=animationpetal3
        svgPetal90.animation=animationpetal4



    }
}


