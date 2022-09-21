package com.utn.simplelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.utn.simplelogin.entities.User

class MainActivity : AppCompatActivity() {

    // Lateinit variables here
    lateinit var txtUser : EditText
    lateinit var txtPass : EditText
    lateinit var btnLogin : Button

    var userList : MutableList<User> = mutableListOf()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Code below here
            userList.add(User("Jose","1234"))
            userList.add(User("Juan","12345"))
            userList.add(User("Pedro","abc"))

            btnLogin = findViewById(R.id.btnLogin)
            txtUser = findViewById(R.id.txtUser)
            txtPass = findViewById(R.id.txtPass)

            btnLogin.setOnClickListener {
                var user = txtUser.text.toString()
                var pass = txtPass.text.toString()
                var newList = userList.filter { us ->
                    us.user == user && us.pass == pass
                }

                if (newList.isEmpty())
                    Snackbar.make(it,"INCORRECTOo",Snackbar.LENGTH_SHORT).show()
                else
                    Snackbar.make(it,"CORRECTO",Snackbar.LENGTH_SHORT).show()

            }

        }
}