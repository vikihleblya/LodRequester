package com.example.roman.lodaddplaction.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.roman.lodaddplaction.data.RequestDatabase
import com.example.roman.lodaddplaction.data.RequestProvider
import com.example.roman.lodaddplaction.models.RequestModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RequestViewModel(app: Application) : AndroidViewModel(app), RequestProvider {


    private val requestDatabase = RequestDatabase.getDatabase(app)

    override fun getRequests(): Flowable<List<RequestModel>> {
        return requestDatabase.requestDataDao().getAll()
    }

    fun sortByPrice(): Flowable<List<RequestModel>>{
        return requestDatabase.requestDataDao().sortByCost()
    }

    fun setNewRequest(newRequest: RequestModel) {
        Completable.create {
            requestDatabase.requestDataDao().insert(newRequest)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

    }
}