package com.example.kotlinanimemangaapp.di

import com.example.kotlinanimemangaapp.common.BASE_URL
import com.example.kotlinanimemangaapp.data.remote.api.MangaApi
import com.example.kotlinanimemangaapp.data.repository.MangaDatasource
import com.example.kotlinanimemangaapp.domain.repository.MangaRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val loggingInterceptor = LoggingInterceptor()
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideMangaApi(): MangaApi = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(MangaApi::class.java)

    @Provides
    @Singleton
    fun provideMangaRepository(mangaApi: MangaApi): MangaRepository =
        MangaDatasource(mangaApi)
}

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val url = request.url
        val fullUrl = "${url.scheme}://${url.host}${url.encodedPath}"
        println("URL interrogée : $fullUrl")
        return chain.proceed(request)
    }
}