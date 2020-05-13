package com.ua.eugenezaychenko.attractez.data.repository.models

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class FilmDataModel constructor(@SerializedName("itemId") val itemID: String,
                                     @SerializedName("name") val name: String,
                                     @SerializedName("description") val description: String,
                                     @SerializedName("image") val imgURL: String,
                                     @SerializedName("time") val time: String,
                                     var bitmap: Bitmap? = null)