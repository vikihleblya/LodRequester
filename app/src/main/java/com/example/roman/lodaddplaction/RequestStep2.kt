package com.example.roman.lodaddplaction

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.request_step_2.*

class RequestStep2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_step_2)

        goToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        goToStepOne.setOnClickListener{
            val intent = Intent(this, RequestStep1::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
    }
    override fun onDestroy() {
        super.onDestroy()
    }

}
