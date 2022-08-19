package com.androiddev.specs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import com.androiddev.specs.R


class WriteLetterFragment : Fragment() {
    private lateinit var edtTxtLetterW : EditText
    private lateinit var sendEmail : EditText
    private lateinit var sendMailBtn : ImageButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_write_letter, container, false)

        edtTxtLetterW = view.findViewById(R.id.edtTxtLetterW)
        sendEmail = view.findViewById(R.id.sendEmail)
        sendMailBtn = view.findViewById(R.id.sendMailBtn)

        sendMailBtn.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame, FinalSendFragment())
            transaction.disallowAddToBackStack()
            transaction.commit()
        }


        return view
    }

}