package com.example.android.animationsdemo

import android.animation.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var rotateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private  var translateAnimator: Animator? = null
    private var fadeAnimator: Animator? = null


    //Implementation of AnimationListener
    override fun onAnimationRepeat(p0: Animator?) {
        Toast.makeText(this, "Animation Repeated", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(p0: Animator?) {
        Toast.makeText(this, "Animation Ended", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(p0: Animator?) {
        Toast.makeText(this, "Animation Canceled", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationStart(p0: Animator?) {
        if (p0 == scaleAnimator) {
            Toast.makeText(this, "Scale Animation Started", Toast.LENGTH_SHORT).show()
        }
        if (p0 == rotateAnimator) {
            Toast.makeText(this, "Rotate Animation Started", Toast.LENGTH_SHORT).show()
        }
        if (p0 == translateAnimator) {
            Toast.makeText(this, "Translate Animation Started", Toast.LENGTH_SHORT).show()
        }
        if (p0 == fadeAnimator) {
            Toast.makeText(this, "Fade Animation Started", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun rotateAnimation(view: View) {

        rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun scaleAnimation(view: View) {

        scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun translateAnimation(view: View) {

         translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun fadeAnimation(view: View) {

         fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)
        fadeAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
//        fadeAnimator.setTarget(targetImage)
//        fadeAnimator.start()
    }

    fun translateAnim(view: View){
       val translateAnimator = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, 200f)
        translateAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun setFromXML(view: View) {

        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(targetImage)
            start()
        }
    }

    fun setFromCode(view: View) {
        // Root Animator Set
        val rootSet = AnimatorSet()

// Flip Animation
        val flip = ObjectAnimator.ofFloat(targetImage, "rotationX", 0.0f, 360.0f)
        flip.duration = 500

// Child Animator Set
        val childSet = AnimatorSet()

// Scale Animations
        val scaleX = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        scaleX.interpolator = BounceInterpolator()

        val scaleY = ObjectAnimator.ofFloat(targetImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
        scaleY.interpolator = BounceInterpolator()

//        rootSet.playSequentially(flip, childSet)
//        childSet.playTogether(scaleX, scaleY)
        // OR u can Use

        rootSet.play(flip).before(childSet)
        childSet.play(scaleX).with(scaleY)
        rootSet.start()
    }
    fun viewPropertyAnimator(view: View) {
        val vpa : ViewPropertyAnimator = targetImage.animate()

        vpa.apply {
            duration = 1000
            rotationX(360.0f)
            scaleX(1.5f)
            scaleY(1.5f)
            interpolator = BounceInterpolator()
            start()
        }

    }


    fun propertyValuesHolder(view: View) {
        val rotX : PropertyValuesHolder = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val scaX : PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
        val scaY : PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY", 1.5f)

        val objA : ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(targetImage, rotX, scaX, scaY)
        objA.apply {
            duration = 1000
            interpolator = OvershootInterpolator()
            start()
        }
    }

    fun DrawableAnim(view: View){
        intent = Intent(this, DrawablesAnim::class.java)
        startActivity(intent)
    }
}
