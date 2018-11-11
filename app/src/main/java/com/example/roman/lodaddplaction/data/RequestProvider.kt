package com.example.roman.lodaddplaction.data

import com.example.roman.lodaddplaction.models.RequestModel
import io.reactivex.Flowable

interface RequestProvider {
    fun getRequests() : Flowable<List<RequestModel>>
}