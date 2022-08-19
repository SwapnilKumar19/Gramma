package com.androiddev.specs.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.androiddev.specs.R
import com.androiddev.specs.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var edtName : EditText
    private lateinit var edtAddress : EditText
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnSignUp : Button
    private lateinit var btnlogin : TextView
    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtName = findViewById(R.id.edt_name)
        edtAddress = findViewById(R.id.edt_address)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnSignUp = findViewById(R.id.btn_sign)
        btnlogin = findViewById(R.id.btn_log)

        btnSignUp.setOnClickListener {
            val name = edtName.text.toString()
            val address = edtAddress.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(name,address,email,password)
        }
    }

    private fun signUp(name: String, address: String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    addUserToDatabase(name,address, email,mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@SignUpActivity, "Some error occured", Toast.LENGTH_SHORT)
                }
            }
    }

    private fun addUserToDatabase(name: String, address: String, email: String, uid: String) {
            mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(name,address,email,uid))
    }
}