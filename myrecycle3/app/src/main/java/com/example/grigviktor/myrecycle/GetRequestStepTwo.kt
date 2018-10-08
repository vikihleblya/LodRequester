package com.example.grigviktor.myrecycle

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_get_request_step_two.*

class GetRequestStepTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_request_step_two)

        goToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        goToStepOne.setOnClickListener{
            val intent = Intent(this, GetRequestStepOne::class.java)
            startActivity(intent)
        }
    }

}
