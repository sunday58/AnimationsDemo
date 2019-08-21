package com.example.android.animationsdemo

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_wifi_animation.*

class WifiAnimation : AppCompatActivity() {

    lateinit var wifiAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_animation)
    }

    override fun onStart() {
        super.onStart()

        targetImage.setBackgroundResource(R.drawable.wifi_animation_list)
        wifiAnimation = targetImage.background as AnimationDrawable
        wifiAnimation.start()
    }

    fun startStopAnimation(view: View){

        if (wifiAnimation.isRunning)
            wifiAnimation.stop()
        else wifiAnimation.start()
    }

    fun VectorAnimation(view: View){
        intent = Intent(this, VectorActivity::class.java)
        startActivity(intent)
    }
}
