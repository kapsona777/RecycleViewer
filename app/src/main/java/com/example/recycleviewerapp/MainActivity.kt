package com.example.recycleviewerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val items=ArrayList<ItemModel>()
    private lateinit var adapter:RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setData()
    }

    private fun init(){
        recyclerView.layoutManager= LinearLayoutManager(this)
        adapter=RecyclerViewAdapter(items,this)
        recyclerView.adapter=adapter
        itemButton.setOnClickListener{
            items.add(ItemModel(R.mipmap.instagram, "Instagram", "Social Hub", Date()))
            adapter.notifyItemInserted(items.size - 1)
            recyclerView.scrollToPosition(items.size - 1)
        }
    }

    private fun setData(){
        items.add(ItemModel(R.mipmap.instagram, "Instagram", "Social Hub", Date()))
        items.add(ItemModel(R.mipmap.steam, "Steam", "Gaming Hub", Date()))
        items.add(ItemModel(R.mipmap.youtube, "Youtube", "Music Hub",Date()))
        items.add(ItemModel(R.mipmap.fb, "Facebook", "Social Hub",Date() ))


    }
}
