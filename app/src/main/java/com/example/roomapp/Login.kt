package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room

class Login : AppCompatActivity() {
    lateinit var  email:EditText
    lateinit var password:EditText
    lateinit var room:authDatabase
    lateinit var launch:Intent
    lateinit var launch2:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        launch= Intent(this,MainActivity::class.java)
        launch2= Intent(this,Register::class.java)

        val login: Button =findViewById(R.id.button5)
        login.setOnClickListener {

            Thread(Runnable {
                loginuser()
            }).start()
        }
    }

    fun loginuser(){
        email=findViewById(R.id.et5)
        password=findViewById(R.id.et6)

        val useremail=email.text.toString()
        val userpassword=password.text.toString()
        room= Room.databaseBuilder(applicationContext,authDatabase::class.java,"authdatabase").build()
        val mail=room.getauthuser().getdata()[0].useremail
        val password=room.getauthuser().getdata()[0].userpassword

        if(useremail.equals(mail) && userpassword.equals(password)){
            startActivity(launch)
        }
        else{
            startActivity(launch2)
        }


    }
}