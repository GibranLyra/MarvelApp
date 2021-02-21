package com.example.counterservice.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\tH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/example/counterservice/di/NetworkModule;", "", "()V", "networkModule", "Lorg/koin/core/module/Module;", "getNetworkModule$annotations", "getNetworkModule", "()Lorg/koin/core/module/Module;", "provideCallAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "provideConverterFactory", "Lretrofit2/Converter$Factory;", "provideCounterService", "Lcom/example/counterservice/api/remote/CounterService;", "retrofit", "Lretrofit2/Retrofit;", "provideLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "loggingInterceptor", "provideRetrofit", "okHttpClient", "converterFactory", "adapterFactory", "counterservice_debug"})
@kotlinx.serialization.ExperimentalSerializationApi()
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module networkModule = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.counterservice.di.NetworkModule INSTANCE = null;
    
    @androidx.annotation.VisibleForTesting(otherwise = androidx.annotation.VisibleForTesting.PRIVATE)
    @java.lang.Deprecated()
    public static void getNetworkModule$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.koin.core.module.Module getNetworkModule() {
        return null;
    }
    
    private final retrofit2.CallAdapter.Factory provideCallAdapterFactory() {
        return null;
    }
    
    private final retrofit2.Converter.Factory provideConverterFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlinx.serialization.ExperimentalSerializationApi()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    retrofit2.Converter.Factory converterFactory, @org.jetbrains.annotations.NotNull()
    retrofit2.CallAdapter.Factory adapterFactory) {
        return null;
    }
    
    private final okhttp3.OkHttpClient provideOkHttpClient(okhttp3.logging.HttpLoggingInterceptor loggingInterceptor) {
        return null;
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor provideLoggingInterceptor() {
        return null;
    }
    
    private final com.example.counterservice.api.remote.CounterService provideCounterService(retrofit2.Retrofit retrofit) {
        return null;
    }
    
    private NetworkModule() {
        super();
    }
}