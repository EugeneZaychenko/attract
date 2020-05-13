package com.ua.eugenezaychenko.attractez.data

import com.ua.eugenezaychenko.attractez.data.repository.models.FilmDataModel
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

interface IAttractService {

    companion object {
        const val BASE_URL_ATTRACT_SERVICE = "http://test.php-cd.attractgroup.com/"
    }

    @GET("test.json")
    fun getFilms(): Single<List<FilmDataModel>>

    @Streaming
    @GET
    fun downloadImg(@Url url: String): Observable<Response<ResponseBody>>

}