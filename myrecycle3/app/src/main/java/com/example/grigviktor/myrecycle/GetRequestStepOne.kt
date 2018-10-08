package com.example.grigviktor.myrecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v7.view.menu.MenuBuilder
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_get_request_step_one.*
import java.util.zip.Inflater


class GetRequestStepOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_request_step_one)

        goToStepTwo.setOnClickListener{
            val intent = Intent(this, GetRequestStepTwo::class.java)
            startActivity(intent)
        }

        goToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val myStrings = arrayOf("Горняк-1", "Горняк-2", "Металлург", "Дом-коммуна")
        spinner.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, myStrings)
        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}

        }

    }


}


