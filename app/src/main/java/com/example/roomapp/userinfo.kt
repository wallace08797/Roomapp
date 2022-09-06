package com.example.roomapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class userinfo(
    @PrimaryKey(autoGenerate = true)
    val uniqueid:Int,
    val useremail:String,
    val userpassword:String

)
