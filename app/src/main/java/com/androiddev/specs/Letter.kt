package com.androiddev.specs

import android.widget.ImageView

data class Letter(
    val senderName: String,
    val senderAddress : String,
    val receiverName : String,
    val receiverAddress: String,
    val stampImage : Int,
    val audioImage : Int
)