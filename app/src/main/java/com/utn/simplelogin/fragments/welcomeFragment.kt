package com.utn.simplelogin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.utn.simplelogin.R

class welcomeFragment : Fragment() {

    lateinit var v : View
    lateinit var txtWelcome : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_welcome, container, false)

        txtWelcome = v.findViewById(R.id.txtWelcome)

        return v
    }

    override fun onStart() {
        super.onStart()

        val welcome = welcomeFragmentArgs.fromBundle(requireArguments()).msgWelcome
        txtWelcome.text = welcome
    }
}