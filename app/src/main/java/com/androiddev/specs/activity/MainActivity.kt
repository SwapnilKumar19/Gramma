package com.androiddev.specs.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.androiddev.specs.R
import com.androiddev.specs.fragments.AccountFragment
import com.androiddev.specs.fragments.HomeFragment
import com.androiddev.specs.fragments.MailboxFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_bar)

        setCurrentFragment(HomeFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    setCurrentFragment(HomeFragment())
                    true
                }
                R.id.mailbox -> {
                    setCurrentFragment(MailboxFragment())
                    true
                }
                R.id.account -> {
                    setCurrentFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }

    }
    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.frame,fragment)
            commit()
        }
    }
}