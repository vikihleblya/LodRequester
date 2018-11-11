package com.example.roman.lodaddplaction.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.roman.lodaddplaction.models.RequestModel
import io.reactivex.Flowable

@Dao
interface RequestDataDao {
    @Query("SELECT * from request_table")
    fun getAll(): Flowable<List<RequestModel>>

    @Query("SELECT * from request_table ORDER BY cost")
    fun sortByCost(): Flowable<List<RequestModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(requestModel: RequestModel)



}