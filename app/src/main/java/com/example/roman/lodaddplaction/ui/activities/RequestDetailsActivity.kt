package com.example.roman.lodaddplaction.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.roman.lodaddplaction.R
import com.example.roman.lodaddplaction.models.RequestModel
import kotlinx.android.synthetic.main.activity_request_details.*
import kotlinx.android.synthetic.main.item_request.*

class RequestDetailsActivity : AppCompatActivity() {
    var model : RequestModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_details)
        model = intent.getSerializableExtra("data") as RequestModel

    }

    override fun onResume() {
        super.onResume()

        tv_username.text = getString(R.string.name) + " " + model?.user?.name
        tv_destination.text = model?.distance.toString()
        tv_cost.text = getString(R.string.priceis) + " " + model?.cost?.toString()
        tv_dorm.text = getString(R.string.dormitory) + " " + model?.dormitory
        tv_request_title.text = model?.title
        tv_tags.text = model?.tags?.joinToString(", ")
        Glide.with(this)
                .load(model?.user?.avaUrl)
                .into(iv_avatar)
    }
}
