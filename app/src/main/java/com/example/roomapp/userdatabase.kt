package com.example.roomapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [userdata::class], version = 1)
 abstract class userdatabase: RoomDatabase() {

     abstract fun userdata():userDao
}