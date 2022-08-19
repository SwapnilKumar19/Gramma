package com.androiddev.specs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import com.androiddev.specs.R

class AccountFragment : Fragment() {
    private lateinit var accDetails : LinearLayoutCompat
    private lateinit var rateUs : LinearLayoutCompat
    private lateinit var shareApp : LinearLayoutCompat
    private lateinit var termsOfService : LinearLayoutCompat
    private lateinit var privacyPolicy : LinearLayoutCompat
    private lateinit var deleteAccount : LinearLayoutCompat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        accDetails = view.findViewById(R.id.accDetails)
        rateUs = view.findViewById(R.id.rateUs)
        shareApp = view.findViewById(R.id.shareApp)
        termsOfService = view.findViewById(R.id.termsOfService)
        privacyPolicy = view.findViewById(R.id.privacyPolicy)
        deleteAccount = view.findViewById(R.id.deleteAccount)

        accDetails.setOnClickListener {


        }


        return view
    }

}