package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    lateinit var  email:EditText
    lateinit var password:EditText
    lateinit var room:authDatabase
    lateinit var launch:Intent
    lateinit var launch2:Intent
    lateinit var mauth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        launch= Intent(this,Home::class.java)
        launch2= Intent(this,Register::class.java)
        var mail:String=""
        var pass:String=""
        email=findViewById(R.id.et5)
        password=findViewById(R.id.et6)



        Thread(Runnable {

            try{
                room=Room.databaseBuilder(this,authDatabase::class.java,"authdatabase").build()
                mail=room.getauthuser().getuseremail()
                pass=room.getauthuser().getuserpass()
            }
           catch (e:ArrayIndexOutOfBoundsException){
               e.message
           }


        }).start()






        val login: Button =findViewById(R.id.button5)
        login.setOnClickListener {
           val usermail=email.text.toString()
            val userpassword=password.text.toString()
            if(mail.isNullOrEmpty() && pass.isNullOrEmpty()){
                mauth= FirebaseAuth.getInstance()
                mauth.signInWithEmailAndPassword(usermail,userpassword).addOnCompleteListener {

                    if(it.isSuccessful){
                        val intent:Intent=Intent(this,Home::class.java)
                        startActivity(intent)
                    }

                }

            }
            else{
              Thread(Runnable {
                  loginuser()
              }).start()
            }


        }
    }

    fun loginuser(){
        email=findViewById(R.id.et5)
        password=findViewById(R.id.et6)

        val useremail=email.text.toString()
        val userpassword=password.text.toString()
        room= Room.databaseBuilder(applicationContext,authDatabase::class.java,"authdatabase").build()
        val mail=room.getauthuser().getuseremail()
        val password=room.getauthuser().getuserpass()

        if(useremail.equals(mail) && userpassword.equals(password)){
            startActivity(launch)
        }
        else{
            startActivity(launch2)
        }


    }
}