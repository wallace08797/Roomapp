package com.example.roomapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface authDAO {

    @Insert
    fun registeruser(user:userinfo)



    @Query("SELECT useremail FROM USERINFO")
    fun getuseremail():String


    @Query("Select userpassword FROM USERINFO")
    fun getuserpass():String



}