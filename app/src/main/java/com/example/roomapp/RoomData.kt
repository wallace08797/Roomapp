package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.get
import androidx.room.Room

class RoomData : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var room:userdatabase
    lateinit var view:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_data)
         view=findViewById(R.id.textView)
        val receive:Button=findViewById(R.id.button3)

        receive.setOnClickListener{
            Thread(Runnable {
                getdata()
            }).start()
        }
    }

    fun getdata(){
        room=Room.databaseBuilder(applicationContext,userdatabase::class.java,"userdatabase").build()
        val data:String=room.userdata().getuser().toString()
        view.setText(data)

    }

}