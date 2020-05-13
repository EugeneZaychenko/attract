package com.ua.eugenezaychenko.attractez.ui.film_info.models

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmInfoModel constructor(val itemID: String,
                                     val name: String,
                                     val description: String,
                                     var bitmap: Bitmap? = null) : Parcelable