package com.ua.eugenezaychenko.attractez.data.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ua.eugenezaychenko.attractez.data.repository.db.dao.FilmDao
import com.ua.eugenezaychenko.attractez.data.repository.db.entity.FilmEntity

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun filmDao(): FilmDao

}
