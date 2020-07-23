package com.example.haikalharin.newsDB

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                // TODO Auto-generated method stub
                val i = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(i)
                this.finish()
            }

            private fun finish() {
                // TODO Auto-generated method stub
            }
        }, splashInterval.toLong())
    }

    companion object {
        private const val splashInterval = 2000
    }
}