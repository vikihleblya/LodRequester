package com.example.roman.lodaddplaction.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "request_table")
class RequestModel(
        val title: String,
        val tags: List<String>?,
        val description: String,
        val cost: Int,
        @Embedded val user: UserModel?,
        val dormitory: String,
        val latitude: Double?,
        val longitude: Double?,
        var distance: Double?
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
