package com.utn.simplelogin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.utn.simplelogin.R
import com.utn.simplelogin.entities.User

class loginFragment : Fragment() {

    lateinit var v : View
    lateinit var txtUser : EditText
    lateinit var txtPass : EditText
    lateinit var btnLogin : Button

    var userList : MutableList<User> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)

        userList.add(User("Jose","1234"))
        userList.add(User("Juan","12345"))
        userList.add(User("Pedro","abc"))

        btnLogin = v.findViewById(R.id.btnLogin)
        txtUser = v.findViewById(R.id.txtUser)
        txtPass = v.findViewById(R.id.txtPass)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnLogin.setOnClickListener {
            var user = txtUser.text.toString()
            var pass = txtPass.text.toString()
            var newList = userList.filter { us ->
                us.user == user && us.pass == pass
            }

            if (newList.isEmpty())
                Snackbar.make(it,"Datos incorrectos", Snackbar.LENGTH_SHORT).show()
            else
                Snackbar.make(it,"Autenticado", Snackbar.LENGTH_SHORT).show()
                val action = loginFragmentDirections.actionLoginFragmentToWelcomeFragment("Bienvenido $user")
                v.findNavController().navigate(action)
        }
    }

}