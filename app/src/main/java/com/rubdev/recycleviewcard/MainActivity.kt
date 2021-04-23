package com.rubdev.recycleviewcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        updateList()
    }

    private fun bindView() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    //    dados mokados
    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Rubens Moura",
                    "(85)98203-8002",
                    "img.jpg"
                ),
                Contact(
                    "Talita Moura",
                    "(85)98119-8001",
                    "img.jpg"
                )
            )
        )
    }
}