package com.gibran.marvelservice.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.gibran.marvelservice.api.remote.MarvelService
import com.gibran.marvelservice.util.MarvelKey
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
import java.util.*
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 20L
private const val BASE_URL = "https://gateway.marvel.com:443/"

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
        return Json {
           ignoreUnknownKeys = true
        }.asConverterFactory(contentType)
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
            .addInterceptor { chain ->
                val original = chain.request()

                val currentTime = Date().time.toString()
                val publicKey = "468470cb48e5cf4f799c5e456d618593"
                val privateKey = "565fa3c1089c866b4adf453dd79b54319f4bd454"

                val url = original.url.newBuilder()
                    .addQueryParameter("ts", currentTime)
                    .addQueryParameter("apikey", publicKey)
                    .addQueryParameter("hash", MarvelKey.generateUserKey(currentTime, privateKey, publicKey))
                    .build()
                val requestBuilder = original.newBuilder().url(url)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
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
