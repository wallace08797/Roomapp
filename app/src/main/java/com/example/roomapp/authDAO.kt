package com.example.roomapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface authDAO {

    @Insert
    fun registeruser(user:userinfo)



    @Query("SELECT * FROM USERINFO")
    fun getdata():List<userinfo>



}