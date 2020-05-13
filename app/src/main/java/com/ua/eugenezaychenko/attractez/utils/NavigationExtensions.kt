package com.ua.eugenezaychenko.attractez.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.replaceWithBackStack(frame: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(frame, fragment)
            .addToBackStack(null)
            .commit()
}

fun FragmentActivity.replace(frame: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(frame, fragment)
            .commit()
}