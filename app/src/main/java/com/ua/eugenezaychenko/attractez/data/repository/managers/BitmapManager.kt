package com.ua.eugenezaychenko.attractez.data.repository.managers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

class BitmapManager @Inject constructor(private val context: Context) : IBitmapManager {

    override fun saveBitmapInInternalStorage(bitmap: Bitmap, filmDataModel: FilmDataModel) {
        val file = File(context.getExternalFilesDir(null), "${filmDataModel.itemID}.$FILE_TYPE")
        if (file.exists()) return
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, QUALITY, fos)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            fos?.flush()
            fos?.close()
        }
    }

    override fun loadImageBitmap(filmDataModel: FilmDataModel): Bitmap? {
        val file = File(context.getExternalFilesDir(null), "${filmDataModel.itemID}.$FILE_TYPE")
        if (!file.exists()) return null

        val fileInputStream: FileInputStream = file.inputStream()
        var bitmap: Bitmap? = null
        try {
            bitmap = BitmapFactory.decodeStream(fileInputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fileInputStream.close()
        }
        return bitmap
    }

    override fun isImgInStorageAvailable(list: List<FilmDataModel>, imgMap: LinkedHashMap<String, Bitmap>): Boolean {
        val bitmapList = mutableListOf<Pair<String, Bitmap>>()
        list.forEach { filmDataMode ->
            val bitmap = loadImageBitmap(filmDataMode)
            bitmap?.let {
                bitmapList.add(filmDataMode.itemID to it)
                imgMap[filmDataMode.itemID] = it
            }
        }

        val isImgInStorageAvailable = bitmapList.size == list.size

        if (isImgInStorageAvailable) list.forEach { it.bitmap = imgMap[it.itemID] }

        return isImgInStorageAvailable
    }

    companion object {
        private const val FILE_TYPE = "jpg"
        private const val QUALITY = 100
    }
}