package com.example.haikalharin.newsDB.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.haikalharin.newsDB.DetailActivity
import com.example.haikalharin.newsDB.Entity.News
import com.example.haikalharin.newsDB.R

class NewsAdapter(private val context: Context, private val list: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_news, null, false)
        val layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        v.layoutParams = layoutParams
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = list[position]
        Glide.with(context).load(news.imgNews).into(holder.gmb)
        holder.judul.text = news.titleNews
        holder.tgl.text = news.dateNews.substring(0, 10) + " " + news.dateNews.substring(11, 16)
        if (news.authorNews == null) {
            holder.penulis.text = "Penulis Tidak Diketahui"
        } else {
            holder.penulis.text = news.authorNews
        }
        holder.cv.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("imgNews", news.imgNews)
            i.putExtra("titleNews", news.titleNews)
            if (news.contentNews == null) {
                i.putExtra("contentNews", "No Description")
            } else {
                i.putExtra("contentNews", news.contentNews)
            }
            i.putExtra("dateNews", news.dateNews.substring(0, 10) + " " + news.dateNews.substring(11, 16))
            if (news.authorNews == null) {
                i.putExtra("authorNews", "Unknown Author")
            } else {
                i.putExtra("authorNews", news.authorNews)
            }
            i.putExtra("sourceNews", news.sourceNews)
            context.startActivity(i)
            (context as Activity).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cv: CardView
        val gmb: ImageView
        val judul: TextView
        val tgl: TextView
        val penulis: TextView

        init {
            cv = itemView.findViewById(R.id.cv)
            gmb = itemView.findViewById(R.id.gambar)
            judul = itemView.findViewById(R.id.judul)
            tgl = itemView.findViewById(R.id.tgl)
            penulis = itemView.findViewById(R.id.penulis)
        }
    }

}