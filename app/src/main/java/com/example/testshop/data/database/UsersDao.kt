package com.example.testshop.data.database

import androidx.room.*

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertUser(users: UserDbModel)

    @Query("DELETE FROM users WHERE fist_name=:fistName")
    suspend fun deleteUser(fistName: String)

    @Query("SELECT * FROM users WHERE email LIKE :email ")
    suspend fun getEmailUser(email: String): UserDbModel?

    @Query("SELECT * FROM users WHERE fist_name LIKE :firstName ")
    suspend fun getFirstNameUser(firstName: String): UserDbModel?
}