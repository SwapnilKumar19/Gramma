package com.androiddev.specs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.androiddev.specs.R
import com.google.firebase.auth.FirebaseAuth


class AccountDetailsFragment : Fragment() {
    private lateinit var name: EditText
    private lateinit var address : EditText
    private lateinit var email :EditText
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account_details, container, false)

        mAuth = FirebaseAuth.getInstance()
        name = view.findViewById(R.id.eTxtName)
        email = view.findViewById(R.id.eTxtEmail)
        address = view.findViewById(R.id.eTxtAddress)

        name.setText(mAuth.currentUser?.displayName)
        email.setText(mAuth.currentUser?.email)
        return view
    }

}