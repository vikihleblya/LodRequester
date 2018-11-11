package com.example.roman.lodaddplaction.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.roman.lodaddplaction.R
import kotlinx.android.synthetic.main.request_step_1.*

class RequestStep1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_step_1)

        goToMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        goToStepTwo.setOnClickListener{
            val title = et_name.text.toString()
            val description = et_description.text.toString()
            val dormitory = spinner_dormitory.selectedItem
            when {
                title.isEmpty() -> et_name.error = "Cannot be empty"
                description.isEmpty() -> et_description.error = "Cannot be empty"
                else -> {val intent = Intent(this, RequestStep2Activity::class.java)
                    intent.putExtra("TITLE", title)
                    intent.putExtra("DESCRIPTION", description)
                    intent.putExtra("DORMITORY", dormitory.toString())
                    startActivity(intent)
                    finish()
                }
            }
        }
        val spinner: Spinner = findViewById(R.id.spinner_dormitory)
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





