package com.androiddev.specs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PenpalAdapter (val context: Context, val ppItemList : ArrayList<Penpal>): RecyclerView.Adapter<PenpalAdapter.PenpalViewHolder>(){

    class PenpalViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val Name : TextView = view.findViewById(R.id.name)
        val Address : TextView = view.findViewById(R.id.address)
        val ppcardLayout : CardView = view.findViewById(R.id.ppCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenpalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_penpal, parent,false)
        return PenpalViewHolder(view)
    }

    override fun onBindViewHolder(holder: PenpalViewHolder, position: Int) {
        val penFriend = ppItemList[position]
        holder.Name.text = penFriend.name
        holder.Address.text = penFriend.address

        /*holder.consLayout.setOnClickListener {
            Toast.makeText(context, "Clicked on ${holder.textcategoryname.text}", Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun getItemCount(): Int {
        return ppItemList.size
    }
}