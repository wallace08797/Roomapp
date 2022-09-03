package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class RoomData : AppCompatActivity() {
    lateinit var room:userdatabase
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_data)

        Thread(Runnable {
            getdata()
        }).start()

    }

    fun getdata(){
        room=Room.databaseBuilder(applicationContext,userdatabase::class.java,"userdatabase").build()
       val list:List<userdata>
       recyclerView=findViewById(R.id.recycler1)
       list=room.userdata().getuser()
        recyclerView.adapter=Adapter(list)
        recyclerView.layoutManager=LinearLayoutManager(this)

    }



}