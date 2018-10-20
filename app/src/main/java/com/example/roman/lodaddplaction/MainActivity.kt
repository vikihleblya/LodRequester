package com.example.roman.lodaddplaction

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.widget.Toast
import com.example.roman.lodaddplaction.adapters.RequestAdapter
import com.example.roman.lodaddplaction.data.MockRequestProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.function.Supplier

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RequestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_requests.layoutManager = layoutManager
        setSupportActionBar(app_bar)
    }

    override fun onResume() {
        super.onResume()
        fab.setOnClickListener{
            val intent = Intent(this, RequestStep1::class.java)
            startActivity(intent)
            onStop()
        }
        adapter = RequestAdapter(this, MockRequestProvider().getRequests())
        rv_requests.adapter = adapter
        rv_requests.layoutManager = LinearLayoutManager(this)
        readToken()

    }

    private fun readToken() {
        val token = getSharedPreferences("default", Context.MODE_PRIVATE)
                .getString("accessToken", "")
        Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_bottom_app_bar, menu)
        return true
    }
}
