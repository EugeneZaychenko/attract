package com.ua.eugenezaychenko.attractez.data.repository.managers

import android.graphics.Bitmap
import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel

interface IBitmapManager {

    fun saveBitmapInInternalStorage(bitmap: Bitmap, filmDataModel: FilmDataModel)

    fun loadImageBitmap(filmDataModel: FilmDataModel): Bitmap?

    fun isImgInStorageAvailable(list: List<FilmDataModel>, imgMap: LinkedHashMap<String, Bitmap>): Boolean
}