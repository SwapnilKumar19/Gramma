package com.androiddev.specs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MailboxRecyclerAdapter (val context: Context, val LetterItemList : ArrayList<Letter>): RecyclerView.Adapter<MailboxRecyclerAdapter.MailboxViewHolder>() {

    class MailboxViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val senderName : TextView = view.findViewById(R.id.senderName)
        val senderAddress : TextView = view.findViewById(R.id.senderAddress)
        val receiverName : TextView = view.findViewById(R.id.receiverName)
        val receiverAddress : TextView = view.findViewById(R.id.receiverAddress)
        val audioImage : ImageView = view.findViewById(R.id.audioImage)
        val stampImage : ImageView = view.findViewById(R.id.stampImage)
        val consLayout : ConstraintLayout = view.findViewById(R.id.letterCardLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailboxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_cardview, parent,false)
        return MailboxViewHolder(view)
    }

    override fun onBindViewHolder(holder: MailboxViewHolder, position: Int) {
        val envelope = LetterItemList[position]
        holder.senderName.text = envelope.senderName
        holder.senderAddress.text = envelope.senderAddress
        holder.receiverName.text = envelope.receiverName
        holder.receiverAddress.text = envelope.receiverAddress
        holder.audioImage.setImageResource(envelope.audioImage)
        holder.stampImage.setImageResource(envelope.stampImage)

        /*holder.consLayout.setOnClickListener {
            Toast.makeText(context, "Clicked on ${holder.textcategoryname.text}", Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun getItemCount(): Int {
        return LetterItemList.size
    }

}