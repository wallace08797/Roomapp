package com.example.roomapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class userdata(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val username:String,
    val address:String,

)
