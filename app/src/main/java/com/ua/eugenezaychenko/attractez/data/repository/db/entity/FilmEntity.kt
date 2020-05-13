package com.ua.eugenezaychenko.attractez.data.repository.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film")
class FilmEntity constructor(@PrimaryKey @ColumnInfo(name = "item_id") val itemID: String,
                             @ColumnInfo(name = "name") val name: String,
                             @ColumnInfo(name = "description") val description: String,
                             @ColumnInfo(name = "image") val imgURL: String, @ColumnInfo(name = "time") val time: String
)