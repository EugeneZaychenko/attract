package com.ua.eugenezaychenko.attractez.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ua.eugenezaychenko.attractez.R

class CustomProgressDialog  : DialogFragment() {

    override fun getTheme() = R.style.ProgressDialogThem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        LayoutInflater.from(context).inflate(R.layout.dialog_progressbar, null)
}