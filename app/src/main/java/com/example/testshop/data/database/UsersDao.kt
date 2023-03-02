package com.example.testshop.data.database

import androidx.room.*

@Dao
interface UsersDao {

    @Insert
    suspend fun insertUser(users: UserDbModel)

    @Query("DELETE FROM users WHERE id=:userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT * FROM users WHERE email LIKE :email ")
    suspend fun getEmailUser(email: String) : UserDbModel?

    @Query("SELECT * FROM users WHERE fist_name LIKE :firstName ")
    suspend fun getFirstNameUser(firstName: String) : UserDbModel?
}