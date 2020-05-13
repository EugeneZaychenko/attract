package com.ua.eugenezaychenko.attractez.ui.film_list.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmListItemModel constructor(val itemId: String,
                                         val name: String,
                                         val dateStr: String,
                                         val img: Bitmap?) : Parcelable