package com.example.testshop.data.database

import androidx.room.*

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(users: UsersDbModel)

    @Delete
    suspend fun deleteUser(users: UsersDbModel)

    @Query("SELECT * FROM users ")
    suspend fun getAllUser() : List<UsersDbModel>
}