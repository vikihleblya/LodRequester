package com.example.roman.lodaddplaction.Json

import com.example.roman.lodaddplaction.models.RequestModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SerializableJson{
    fun fromString(string: String) : List<RequestModel>{
        val gson = Gson()
        val listType = object : TypeToken<List<RequestModel>>() {}.type
        return  gson.fromJson(string, listType)
    }
}