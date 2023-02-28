package com.example.testshop.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersDbModel(
    @PrimaryKey
    val firstName: String,
    val secondName: String,
    val email: String,
)