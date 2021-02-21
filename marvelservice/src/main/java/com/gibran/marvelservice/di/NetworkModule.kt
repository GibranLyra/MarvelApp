package com.gibran.marvelservice.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.gibran.marvelservice.api.remote.MarvelService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 20L
private const val BASE_URL = "http://192.168.15.2:3000/api/v1/"

@ExperimentalSerializationApi
object NetworkModule {
    @VisibleForTesting(otherwise = PRIVATE)
    val networkModule = module {
        factory { provideLoggingInterceptor() }
        factory { provideOkHttpClient(get()) }
        factory { provideMarvelService(get()) }
        factory { provideConverterFactory() }
        factory { provideCallAdapterFactory() }
        single { provideRetrofit(get(), get(), get()) }
    }

    private fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.create()

    private fun provideConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        return Json.asConverterFactory(contentType)
    }

    @ExperimentalSerializationApi
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        adapterFactory: CallAdapter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(adapterFactory)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                //The log level would be dependent of the build type. In Release build, it would be NONE
                level = HttpLoggingInterceptor.Level.BASIC
            }
    }

    private fun provideMarvelService(retrofit: Retrofit): MarvelService =
        retrofit.create(MarvelService::class.java)

}
