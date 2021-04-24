package com.rubdev.recycleviewcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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
                    "(85)99999-9992",
                    "img.jpg"
                ),
                Contact(
                    "Talita Moura",
                    "(85)90999-0001 ",
                    "img.jpg"
                )
            )
        )
    }

    // Metodo que infla o layout do menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(message: String){
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    // metodo que observa os itens dos menus observando os toques nos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Exibindo item menu 1")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Exibindo item menu 2")
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
}