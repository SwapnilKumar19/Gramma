package com.androiddev.specs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecentAdapter(val context: Context, val recentItemList : ArrayList<RecentLetter>): RecyclerView.Adapter<RecentAdapter.RecentViewHolder>() {

    class RecentViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val recentName : TextView = view.findViewById(R.id.recentName)
        val recentAddress : TextView = view.findViewById(R.id.recentAddress)
        val letterPreview : TextView = view.findViewById(R.id.letterPreview)
        val recentTime : TextView = view.findViewById(R.id.recentTime)
        val recentaudioImage : ImageView = view.findViewById(R.id.recentaudioImage)
        val recentstampImage : ImageView = view.findViewById(R.id.recentstampImage)
        val recentPreview : CardView = view.findViewById(R.id.recentPreview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentAdapter.RecentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_recent, parent,false)
        return RecentAdapter.RecentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentAdapter.RecentViewHolder, position: Int) {
        val recentItem = recentItemList[position]
        holder.recentName.text = recentItem.recentName
        holder.recentAddress.text = recentItem.recentAddress
        holder.letterPreview.text = recentItem.letterPreview
        holder.recentTime.text = recentItem.recentTime
        holder.recentaudioImage.setImageResource(recentItem.recentAudio)
        holder.recentstampImage.setImageResource(recentItem.recentStamp)

        /*holder.consLayout.setOnClickListener {
            Toast.makeText(context, "Clicked on ${holder.textcategoryname.text}", Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun getItemCount(): Int {
        return recentItemList.size
    }
}