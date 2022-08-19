package com.androiddev.specs.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.specs.Letter
import com.androiddev.specs.MailboxRecyclerAdapter
import com.androiddev.specs.R


class MailboxFragment : Fragment() {

    lateinit var recyclerViewMailbox : RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var mailBoxAdapter : MailboxRecyclerAdapter

    val envList = arrayListOf<Letter>(
        Letter("Amit", "Chennai, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Sushant", "Latur, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Pooja", "Indore, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Kriti", "Mathura, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Raina", "Ladakh, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Samay", "Varanasi, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Johnny", "Mangalore, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),
        Letter("Miller", "Bijnaur, India","Ranbir", "Mumbai, India", R.drawable.stamp_astronaut, R.drawable.sound),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mailbox, container, false)

        recyclerViewMailbox = view.findViewById(R.id.recyclerViewMailbox)
        layoutManager = LinearLayoutManager(activity)
        mailBoxAdapter = MailboxRecyclerAdapter(activity as Context, envList)

        recyclerViewMailbox.adapter = mailBoxAdapter
        recyclerViewMailbox.layoutManager = layoutManager

        return view

    }


}