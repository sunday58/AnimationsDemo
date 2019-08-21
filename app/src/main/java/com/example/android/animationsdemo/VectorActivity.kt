package com.example.android.animationsdemo

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_vector.*

class VectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector)

        var isChecked = true

        avdImage.setOnClickListener {
            if (isChecked)
            checkToClose()
            else
                closeToCheck()
            isChecked = !isChecked
        }
    }

    private fun closeToCheck() {

        avdImage.setImageResource(R.drawable.avd_close_to_check)
        val avdCheckToClose: AnimatedVectorDrawable = avdImage.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    private fun checkToClose(){
        avdImage.setImageResource(R.drawable.avd_check_to_close)
        val avdCheckToClose: AnimatedVectorDrawable = avdImage.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    fun Transition(view: View){
        intent = Intent(this, TransitionActivity::class.java)
        startActivity(intent)
    }

    fun TransitionAnimation(view: View){
        intent = Intent(this, SecondTransition::class.java)
        startActivity(intent)
    }
}
