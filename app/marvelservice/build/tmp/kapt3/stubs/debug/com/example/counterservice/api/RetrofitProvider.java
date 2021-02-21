package com.example.counterservice.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J#\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001bH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/example/counterservice/api/RetrofitProvider;", "", "()V", "BASE_URL", "", "TIME_OUT", "", "logInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "getLogInterceptor", "()Lokhttp3/logging/HttpLoggingInterceptor;", "logInterceptor$delegate", "Lkotlin/Lazy;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "providesRetrofitApi", "T", "clazz", "Ljava/lang/Class;", "providesRetrofitApi$counterservice_debug", "(Ljava/lang/Class;)Ljava/lang/Object;", "counterservice_debug"})
@kotlinx.serialization.ExperimentalSerializationApi()
public final class RetrofitProvider {
    private static final long TIME_OUT = 20L;
    private static final java.lang.String BASE_URL = "https://6026c4ed186b4a0017780abe.mockapi.io/counterApp/";
    private static final kotlin.Lazy logInterceptor$delegate = null;
    private static final kotlin.Lazy okHttpClient$delegate = null;
    private static final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.counterservice.api.RetrofitProvider INSTANCE = null;
    
    private final okhttp3.logging.HttpLoggingInterceptor getLogInterceptor() {
        return null;
    }
    
    private final okhttp3.OkHttpClient getOkHttpClient() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final <T extends java.lang.Object>T providesRetrofitApi$counterservice_debug(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        return null;
    }
    
    private RetrofitProvider() {
        super();
    }
}