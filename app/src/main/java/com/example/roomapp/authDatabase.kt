package com.example.roomapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [userinfo::class], version = 1)
abstract class authDatabase :RoomDatabase(){


    abstract fun getauthuser():authDAO

}