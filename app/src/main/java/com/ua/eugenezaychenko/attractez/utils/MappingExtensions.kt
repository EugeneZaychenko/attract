package com.ua.eugenezaychenko.attractez.utils

import android.graphics.Bitmap
import com.ua.eugenezaychenko.attractez.data.repository.db.entity.FilmEntity
import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import com.ua.eugenezaychenko.attractez.ui.film_info.models.FilmInfoModel
import com.ua.eugenezaychenko.attractez.ui.film_list.model.FilmListItemModel

fun List<FilmDataModel>.toFilmItemList(): List<FilmListItemModel> {
    return this.map {
        FilmListItemModel(
                itemId = it.itemID,
                name = it.name,
                dateStr = it.time.toDateFormat(),
                img = it.bitmap
        )
    }
}

fun List<FilmDataModel>.toFilmEntityList(): List<FilmEntity> {
    return this.map {
        FilmEntity(
                itemID = it.itemID,
                name = it.name,
                description = it.description,
                imgURL = it.imgURL,
                time = it.time
        )
    }
}

fun FilmEntity.toFilmDataMode(imgMap: LinkedHashMap<String, Bitmap>): FilmDataModel {
    return FilmDataModel(
            itemID = itemID,
            name = name,
            description = description,
            imgURL = imgURL,
            time = time,
            bitmap = imgMap[itemID]
    )
}

fun List<FilmEntity>.toFilmDataModelList(imgMap: LinkedHashMap<String, Bitmap>): List<FilmDataModel> {
    return this.map { it.toFilmDataMode(imgMap) }
}

fun List<FilmDataModel>.toFilmInfoModelList(): List<FilmInfoModel> {
    return this.map {
        FilmInfoModel(
                itemID = it.itemID,
                name = it.name,
                description = it.description,
                bitmap = it.bitmap
        )
    }
}
