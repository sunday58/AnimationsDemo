package com.example.android.animationsdemo

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main_detail.*

class KeyFrameActivity : AppCompatActivity() {
    private var isDetailLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_frame)


        constraintLayout.setOnClickListener {
            if (isDetailLayout)
            // switch to default layout
            swapFrames(R.layout.activity_key_frame)
            else
            // switch to detail layout
                swapFrames(R.layout.activity_main_detail)
        }
    }

    private fun swapFrames(layoutId: Int){
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, layoutId)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200


        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)

        isDetailLayout = !isDetailLayout

    }
}
