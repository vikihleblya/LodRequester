package com.example.roman.lodaddplaction.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.roman.lodaddplaction.models.RequestModel

@Database(entities = [RequestModel::class], version = 2)
@TypeConverters(ConverterTags::class)
abstract class RequestDatabase : RoomDatabase() {

    abstract fun requestDataDao(): RequestDataDao

    companion object {
        @Volatile
        private var INSTANCE: RequestDatabase? = null

        fun getDatabase(context: Context): RequestDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        RequestDatabase::class.java,
                        "word_database"
                )
                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}