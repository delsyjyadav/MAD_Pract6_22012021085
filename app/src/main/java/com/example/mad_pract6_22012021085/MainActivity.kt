package com.example.mad_pract6_22012021085

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.drawable.AnimationDrawable
import android.util.Log
import android.view.animation.Animation
import android.widget.ImageView

class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    private lateinit var clockAnimation: AnimationDrawable
    private lateinit var heartAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            clockAnimation = findViewById<ImageView>(R.id.img1).background as AnimationDrawable
            heartAnimation = findViewById<ImageView>(R.id.img2).background as AnimationDrawable
            clockAnimation.start()
            heartAnimation.start()
        } else {
            clockAnimation.stop()
            heartAnimation.stop()
        }
    }
    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        clockAnimation.start()
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }
}