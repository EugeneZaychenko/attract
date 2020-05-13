package com.ua.eugenezaychenko.attractez.data.repository.db.dao

import androidx.room.*
import com.ua.eugenezaychenko.attractez.data.repository.db.entity.FilmEntity
import io.reactivex.Flowable

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFilm(film: FilmEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFilmList(film: List<FilmEntity>)

    @Delete
    fun removeFilm(film: FilmEntity)

    @Query("DELETE FROM film")
    fun clearAll()

    @Query("SELECT * FROM film")
    fun getAllFilms(): Flowable<List<FilmEntity>>

    @Query("SELECT * FROM film WHERE item_id = :filmId")
    fun getFilmById(filmId: String): Flowable<FilmEntity>
}