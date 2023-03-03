package com.example.testshop.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDbModel::class], version = 11, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        private var db: AppDataBase? = null
        private const val DB_NAME = "user.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                instance.openHelper.writableDatabase
                return instance
            }
        }
    }
    abstract fun UsersDao(): UsersDao
}

