package com.example.haikalharin.newsDB

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    var img: String? = null
    var judul: String? = null
    var deskripsi: String? = null
    var tgl: String? = null
    var penulis: String? = null
    var sumber: String? = null
    var tvImg: ImageView? = null
    var tvJudul: TextView? = null
    var tvDeskripsi: TextView? = null
    var tvTgl: TextView? = null
    var tvPenulis: TextView? = null
    var tvSumber: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        img = intent.getStringExtra("imgNews")
        judul = intent.getStringExtra("titleNews")
        deskripsi = intent.getStringExtra("contentNews")
        tgl = intent.getStringExtra("dateNews")
        penulis = intent.getStringExtra("authorNews")
        sumber = intent.getStringExtra("sourceNews")
        bindView()
        Glide.with(applicationContext)
                .load(img).into(tvImg!!)
        tvJudul!!.text = judul
        tvDeskripsi!!.text = deskripsi
        tvTgl!!.text = tgl
        tvSumber!!.text = "Lihat Lebih Lengkap"
        tvPenulis!!.text = penulis
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun sumber(view: View?) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(sumber)))
    }

    fun bindView() {
        tvImg = findViewById(R.id.img)
        tvJudul = findViewById(R.id.judul)
        tvDeskripsi = findViewById(R.id.deskripsi)
        tvPenulis = findViewById(R.id.penulis)
        tvTgl = findViewById(R.id.tgl)
        tvSumber = findViewById(R.id.sumber)
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}