package com.example.grigviktor.myrecycle

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import android.os.Build
import android.view.Menu
import android.view.View
import com.example.grigviktor.myrecycle.R.id.searchView
import android.widget.EditText
import android.widget.SearchView
import com.example.grigviktor.myrecycle.R.id.searchView






class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = TitleAdapter(this, Supplier.titles)
        recyclerView.adapter = adapter

        searchView.setOnClickListener { searchView.isIconified = false }


        fab.setOnClickListener{
            val intent = Intent(this, GetRequestStepOne::class.java)
            startActivity(intent)
        }
        setSupportActionBar(app_bar)


        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_bottom_app_bar, menu)
        return true
    }


}