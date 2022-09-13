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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class Register : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var room:authDatabase
    lateinit var launch: Intent
    lateinit var mauth:FirebaseAuth
    var registercounter:Int=0
    var useremail:String=""
    var userpassword:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val register:Button=findViewById(R.id.button4)
        val go:Button=findViewById(R.id.button8)
        launch=Intent(this,Login::class.java)
        register.setOnClickListener{
            Thread(Runnable {
                registeruser()
                firebaseuser()
            }).start()

            Toast.makeText(this,"user created",Toast.LENGTH_LONG).show()
        }



        go.setOnClickListener{
            val intent:Intent=Intent(this,Login::class.java)
            startActivity(intent)
        }
    }



    fun registeruser(){
        email=findViewById(R.id.et3)
        password=findViewById(R.id.et4)
         useremail=email.text.toString()
         userpassword=password.text.toString()
        room=Room.databaseBuilder(applicationContext,authDatabase::class.java,"authdatabase").build()
        room.getauthuser().registeruser(userinfo(Calendar.getInstance().timeInMillis.toInt(),useremail, userpassword))


    }

    fun firebaseuser(){
        mauth= FirebaseAuth.getInstance()
        mauth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener {

            if(it.isSuccessful){
                startActivity(launch)
            }
        }
    }


}