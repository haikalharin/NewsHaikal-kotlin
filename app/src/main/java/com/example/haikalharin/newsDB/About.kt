package com.example.haikalharin.newsDB

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        window.setLayout((width * .8).toInt(), (height * .6).toInt())
    }

    override fun onBackPressed() {
        val back = Intent(this@About, MainActivity::class.java)
        startActivity(back)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}