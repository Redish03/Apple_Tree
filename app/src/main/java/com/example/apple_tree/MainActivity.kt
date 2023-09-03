package com.example.apple_tree

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnPause
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.apple_tree.databinding.ActivityFirstPageBinding
import com.example.apple_tree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var splashScreen: androidx.core.splashscreen.SplashScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        startSplash()
        setContentView(binding.root)

        val intent = Intent(this, FirstAppleActivity::class.java)
        binding.nextButton.setOnClickListener{startActivity(intent)}
    }

    private fun startSplash() {
        splashScreen.setOnExitAnimationListener{ splashScreenView ->
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X,1f, 5f, 1f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y,1f, 5f, 1f)

            ObjectAnimator.ofPropertyValuesHolder(splashScreenView.iconView, scaleX, scaleY).run {
                interpolator = AnticipateInterpolator()
                duration = 1000L
                doOnEnd {
                    splashScreenView.remove()
                }
                start()
            }
        }
    }
}