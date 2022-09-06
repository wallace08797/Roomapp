package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.Calendar

class Register : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var room:authDatabase
    lateinit var launch: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val register:Button=findViewById(R.id.button4)
        launch=Intent(this,Login::class.java)
        register.setOnClickListener{
            Thread(Runnable {
                registeruser()
            }).start()

            Toast.makeText(this,"user created",Toast.LENGTH_LONG).show()
        }

    }


    fun registeruser(){
        email=findViewById(R.id.et3)
        password=findViewById(R.id.et4)
        val useremail=email.text.toString()
        val userpassword=password.text.toString()
        room=Room.databaseBuilder(applicationContext,authDatabase::class.java,"authdatabase").build()
        room.getauthuser().registeruser(userinfo(Calendar.getInstance().timeInMillis.toInt(),useremail, userpassword))
        startActivity(launch)

    }
}