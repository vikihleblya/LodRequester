package com.example.roman.lodaddplaction.ui.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.roman.lodaddplaction.R
import com.example.roman.lodaddplaction.R.string.price
import com.example.roman.lodaddplaction.models.RequestModel
import com.example.roman.lodaddplaction.models.UserModel
import com.example.roman.lodaddplaction.ui.RequestViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.request_step_2.*
import java.util.*
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ThreadLocalRandom

class RequestStep2Activity : AppCompatActivity() {
    private var disposable: Disposable? = null
    private lateinit var requestViewModel: RequestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_step_2)

        goToMainActivity.setOnClickListener{ view ->
            val tags = et_tags.text.toString()
            val cost = et_cost.text.toString()
            var latitude = 0.0
            var longitude = 0.0
            disposable = MainActivity.getLocation(this)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{latitude = it.latitude; longitude = it.longitude}
            when {
                tags.isEmpty() -> et_tags.error = "Cannot be empty"
                cost.isEmpty() -> et_cost.error = "Cannot be empty"
                else -> {
                    val price : Int = Integer.parseInt(cost)
                    requestViewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
                    val newRequest = RequestModel(
                            intent.getStringExtra("TITLE"),
                            et_tags.text.toString().split(" "),
                            intent.getStringExtra("DESCRIPTION"),
                            price,
                            getMockUser(),
                            intent.getStringExtra("DORMITORY"),
                            latitude, longitude, 0.0
                    )
                    requestViewModel.setNewRequest(newRequest)
                    finish()
                }
            }
        }
        goToStepOne.setOnClickListener{
            val intent = Intent(this, RequestStep1Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun getMockUser(): UserModel = UserModel("John", "")
}
