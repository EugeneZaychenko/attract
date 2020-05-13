package com.ua.eugenezaychenko.attractez.data

import com.google.gson.Gson
import com.ua.eugenezaychenko.attractez.data.IAttractService.Companion.BASE_URL_ATTRACT_SERVICE
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitHelper @Inject constructor(gson: Gson) : IRetrofitHelper {

    private val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())


    override fun getAttractService(): IAttractService {
        return retrofitBuilder
                .client(OkHttpClient())
                .baseUrl(BASE_URL_ATTRACT_SERVICE)
                .build()
                .create(IAttractService::class.java)
    }

}