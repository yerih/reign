package com.admissions.reign.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.admissions.reign.common.Constants
import com.admissions.reign.data.database.dao.HackerNewDao
import com.admissions.reign.data.database.entity.HackerNewEntity


@Database(
    entities = [HackerNewEntity::class],
    version = 1
)

abstract class HackerNewDataBase : RoomDatabase() {
    abstract fun hackerNewDao(): HackerNewDao
    companion object{
        @Volatile
        private var INSTANCE: HackerNewDataBase? = null

        fun getInstance(context: Context): HackerNewDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HackerNewDataBase::class.java,
                        Constants.hackerNewDataBaseName
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}