package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var data:EditText
    lateinit var address:EditText
    lateinit var room:userdatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data=findViewById(R.id.et1)
        address=findViewById(R.id.et2)
      val send:Button=findViewById(R.id.button)
        val show:Button=findViewById(R.id.button2)
        val register:Button=findViewById(R.id.button3)
        register.setOnClickListener{
            val intent:Intent=Intent(this,Register::class.java)
            startActivity(intent)
        }

   show.setOnClickListener{
       val intent:Intent= Intent(this,RoomData::class.java)
       startActivity(intent)

   }

    send.setOnClickListener{
        Thread(Runnable {
            send()
        }).start()

        Toast.makeText(this,"user created",Toast.LENGTH_LONG).show()
    }

    }

    fun send(){
        var username:String=data.text.toString()
        var add:String=address.text.toString()
        room= Room.databaseBuilder(applicationContext,userdatabase::class.java,"userdatabase").build()

        room.userdata().adduser(userdata(Calendar.getInstance().timeInMillis.toInt(),username,add))



    }
}