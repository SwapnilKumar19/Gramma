package com.androiddev.specs.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.specs.*
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    lateinit var precyclerView : RecyclerView
    lateinit var playoutManager: RecyclerView.LayoutManager
    lateinit var pmailBoxAdapter : PenpalAdapter

    lateinit var rrecyclerView : RecyclerView
    lateinit var rlayoutManager: RecyclerView.LayoutManager
    lateinit var rmailBoxAdapter : RecentAdapter

    lateinit var writeLetter : FloatingActionButton

    val penList = arrayListOf<Penpal>(
            Penpal("Akshay", "Mumbai, India"),
        Penpal("Rajeev", "Tokyo, Japan"),
        Penpal("Kajal", "Bhopal, India"),
        Penpal("Ayushi", "Indore, India"),
        Penpal("Sushant", "Bangalore, India"),
        Penpal("Rajesh", "Delhi, India")
        )

    val recentList = arrayListOf<RecentLetter>(
        RecentLetter("Akshay", "Mumbai, India", "Hi, Hello, Namaste", "6:30 AM", R.drawable.stamp_boat, R.drawable.sound),
        RecentLetter("Rajeev", "Tokyo, Japan", "Hi, Hello, Namaste", "8:00 AM", R.drawable.stamp_astronaut, R.drawable.sound),
        RecentLetter("Kajal", "Bhopal, India", "Hi, Hello, Namaste", "7:30 PM", R.drawable.stamp_chess, R.drawable.sound),
        RecentLetter("Ayushi", "Indore, India", "Hi, Hello, Namaste", "12:35 PM", R.drawable.stamp_compass, R.drawable.sound),
        RecentLetter("Sushant", "Bangalore, India", "Hi, Hello, Namaste", "5:23 AM", R.drawable.stamp_earth, R.drawable.sound),
        RecentLetter("Rajesh", "Delhi, India", "Hi, Hello, Namaste", "9:54 PM", R.drawable.stamp_engineering, R.drawable.sound)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //For Pen pals
        precyclerView = view.findViewById(R.id.recyclerViewPenpal)
        playoutManager = LinearLayoutManager(activity)
        pmailBoxAdapter = PenpalAdapter(activity as Context, penList)

        precyclerView.adapter = pmailBoxAdapter
        precyclerView.layoutManager = playoutManager

        //For recently received

        rrecyclerView = view.findViewById(R.id.rRecyclerView)
        rlayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, true)
        rmailBoxAdapter = RecentAdapter(activity as Context, recentList)

        rrecyclerView.adapter = rmailBoxAdapter
        rrecyclerView.layoutManager = rlayoutManager

        writeLetter = view.findViewById(R.id.writeLetter)
        writeLetter.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame, WriteLetterFragment())
            transaction.disallowAddToBackStack()
            transaction.commit()
        }

        return view
    }

}