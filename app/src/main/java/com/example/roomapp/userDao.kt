package com.example.roomapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface userDao {
    @Insert
    fun adduser(user:userdata)


    @Query("SELECT * FROM USERDATA")
    fun getuser():List<userdata>

}