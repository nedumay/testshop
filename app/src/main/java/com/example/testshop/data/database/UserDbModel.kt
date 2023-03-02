package com.example.testshop.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("fist_name")
    val firstName: String,
    @ColumnInfo("second_name")
    val lastName: String,
    @ColumnInfo("email")
    val email: String,
    @ColumnInfo("password")
    val password: String?
)