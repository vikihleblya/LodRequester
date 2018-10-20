package com.example.roman.lodaddplaction

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.request_step_1.*

class RequestStep1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_step_1)

        goToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        goToStepTwo.setOnClickListener{
            val intent = Intent(this, RequestStep2::class.java)
            startActivity(intent)
            onPause()
        }
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.dormitory_array,
                android.R.layout.simple_spinner_dropdown_item)
                .also {
                    it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = it
                }

        }
}




