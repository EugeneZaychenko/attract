package com.ua.eugenezaychenko.attractez.utils

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.text.SimpleDateFormat
import java.util.*


const val DATE_TIME_FORMAT = "dd-MMM-yyyy kk:mm "

fun Context.isOnline(): Boolean {
    val cm = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)
    return cm?.activeNetworkInfo?.isConnectedOrConnecting == true
}

fun ViewGroup.inflateView(resource: Int): View = LayoutInflater.from(context).inflate(resource, this, false)

/**
 * Pattern: dd.MM.yyyy HH:mm:ss
 */
fun String.toDateFormat(): String {
    return try {
        val sdf = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
        sdf.format(this.toLong())
    } catch (e: Exception) {
        ""
    }
}