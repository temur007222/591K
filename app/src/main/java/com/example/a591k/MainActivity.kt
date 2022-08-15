package com.example.a591k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a591k.Adapter.FeedAdapter
import com.example.a591k.Model.Feed
import com.example.a591k.Model.Post
import com.example.a591k.Model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList()
        stories.add(Story(R.drawable.mac, "Xurshidbek Kurbanov"))
        stories.add(Story(R.drawable.nissan, "Begzodbek Kurbanov"))
        stories.add(Story(R.drawable.mac, "Sherzodbek Kurbanov"))
        stories.add(Story(R.drawable.nissan, "Xurshidbek Kurbanov"))
        stories.add(Story(R.drawable.mac, "Begzodbek Kurbanov"))
        stories.add(Story(R.drawable.nissan, "Sherzodbek Kurbanov"))

        val feeds: ArrayList<Feed> = ArrayList()
        //Head
        feeds.add(Feed())
        //Story
        feeds.add(Feed(stories))
        //Post
        feeds.add(Feed(Post(R.drawable.mac, "Xurshidbek", R.drawable.mac)))
        feeds.add(Feed(Post(R.drawable.nissan, "Xurshidbek", R.drawable.nissan)))
        feeds.add(Feed(Post(R.drawable.mac, "Xurshidbek", R.drawable.mac)))
        feeds.add(Feed(Post(R.drawable.nissan, "Xurshidbek", R.drawable.nissan)))
        return feeds
    }
}