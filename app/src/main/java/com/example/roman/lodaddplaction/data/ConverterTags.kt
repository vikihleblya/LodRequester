package com.example.roman.lodaddplaction.data

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterTags {
    @TypeConverter
    fun toString(list: List<String>): String {
        val gson: Gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromString(str: String): List<String> {
        val gson: Gson = Gson()
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(str, listType)
    }
}
