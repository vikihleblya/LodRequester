package com.example.roman.lodaddplaction

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.roman.lodaddplaction.adapters.RequestAdapter
import com.example.roman.lodaddplaction.data.MockRequestProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RequestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
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

    override fun onPause() {
        super.onPause()
    }
}
