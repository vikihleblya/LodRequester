package com.example.roman.lodaddplaction.ui.activities

import android.Manifest
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.PermissionChecker.PERMISSION_GRANTED
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.roman.lodaddplaction.Json.SerializableJson
import com.example.roman.lodaddplaction.Location.getDistanceBetweenTwoMembers
import com.example.roman.lodaddplaction.R
import com.example.roman.lodaddplaction.models.RequestModel
import com.example.roman.lodaddplaction.ui.RequestViewModel
import com.example.roman.lodaddplaction.ui.adapters.RequestAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_main.*

private const val PERMISSION_REQUEST = 10

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    private lateinit var adapter: RequestAdapter
    private var permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    private lateinit var requestViewModel: RequestViewModel
    private var flagToSortByLocation: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_requests.layoutManager = layoutManager
        initRecycler()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!checkPermission(permissions)) {
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        }
        requestViewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
        getRequestsFromJson()
        setLocation()
        getRequests()
        sortByLocation.setOnClickListener { flagToSortByLocation = true; sortByDistance() }
        sortByPrice.setOnClickListener { sortByPrice() }
    }

    override fun onResume() {
        super.onResume()
        fab.setOnClickListener {
            val intent = Intent(this, RequestStep1Activity::class.java)
            startActivity(intent)
            onStop()
        }

    }

    private fun getRequestsFromJson() {
        val json = assets.open("requests.json").bufferedReader().use {
            it.readText()
        }
        val requests: List<RequestModel> = SerializableJson().fromString(json)
        requests.forEach { requestViewModel.setNewRequest(it) }
    }

    private fun getRequests() {
        disposable = requestViewModel.getRequests()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    adapter.updateData(it)
                }
    }

    private fun setLocation() {
        disposable = getLocation(this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { Location ->
                    requestViewModel
                            .getRequests()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe { list ->
                                list.forEach {
                                    it.distance = getDistanceBetweenTwoMembers(
                                            Location.latitude, Location.longitude,
                                            it.latitude!!, it.longitude!!)
                                }
                                if (flagToSortByLocation)
                                    sortByDistance()
                                adapter.updateData(list)
                            }
                }
    }

    private fun checkPermission(permissionArray: Array<String>): Boolean {

        for (i in permissionArray.indices) {
            if (checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
                return false
        }
        return true
    }

    fun sortByPrice() {
        disposable = requestViewModel.sortByPrice()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    adapter.updateData(it)
                }
    }

    fun sortByDistance() = adapter.sortByDistance()

    companion object {
        fun getLocation(context: Context): BehaviorSubject<Location> {
            val subject = BehaviorSubject.create<Location>()
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            if (hasGps) {
                if (ContextCompat.checkSelfPermission(context, ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, object : LocationListener {
                        override fun onLocationChanged(location: Location?) {
                            subject.onNext(location!!)
                        }

                        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                        }

                        override fun onProviderEnabled(provider: String?) {
                        }

                        override fun onProviderDisabled(provider: String?) {
                        }
                    })
                }
            }
            return subject
        }
    }

    private fun initRecycler() {
        adapter = RequestAdapter(this, ArrayList())
        rv_requests.adapter = adapter
        rv_requests.layoutManager = LinearLayoutManager(this)
    }


}