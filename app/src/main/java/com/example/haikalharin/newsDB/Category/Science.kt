@file:Suppress("DEPRECATION")

package com.example.haikalharin.newsDB.Category

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.haikalharin.newsDB.API.ApiService
import com.example.haikalharin.newsDB.API.Server
import com.example.haikalharin.newsDB.Adapter.NewsAdapter
import com.example.haikalharin.newsDB.BuildConfig
import com.example.haikalharin.newsDB.Entity.News
import com.example.haikalharin.newsDB.Entity.ResponseNews
import com.example.haikalharin.newsDB.MainActivity
import com.example.haikalharin.newsDB.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Science : AppCompatActivity() {
    private var news: RecyclerView? = null
    private var adapter: NewsAdapter? = null
    var list: List<News> = ArrayList()
    val category = "science"
    var loading: ProgressDialog? = null
    var api: ApiService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science)
        news = findViewById(R.id.news)
        api = Server.apiService
        adapter = NewsAdapter(this@Science, list)
        news?.setHasFixedSize(true)
        news?.setLayoutManager(LinearLayoutManager(this@Science))
        news?.setAdapter(adapter)
        refresh()

        //membuat back button toolbar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    fun refresh() {
        loading = ProgressDialog(this@Science)
        loading!!.setCancelable(false)
        loading!!.setMessage("Loading...")
        showDialog()
        api!!.getListNews("us", category, BuildConfig.NEWS_API_TOKEN)?.enqueue(object : Callback<ResponseNews?> {
            override fun onResponse(call: Call<ResponseNews?>?, response: Response<ResponseNews?>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        hideDialog()
                        list = response.body()!!.newsList!!
                        news!!.adapter = NewsAdapter(this@Science, list)
                        adapter!!.notifyDataSetChanged()
                    } else {
                        hideDialog()
                        Toast.makeText(this@Science, "Gagal mengambil data !", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseNews?>?, t: Throwable?) {
                hideDialog()
                Toast.makeText(this@Science, "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showDialog() {
        if (!loading!!.isShowing) loading!!.show()
    }

    private fun hideDialog() {
        if (loading!!.isShowing) loading!!.dismiss()
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@Science, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this@Science, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}