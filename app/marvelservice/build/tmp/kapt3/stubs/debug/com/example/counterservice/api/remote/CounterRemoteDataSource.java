package com.example.counterservice.api.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/counterservice/api/remote/CounterRemoteDataSource;", "Lcom/example/counterservice/api/CounterDataSource;", "service", "Lcom/example/counterservice/api/remote/CounterService;", "(Lcom/example/counterservice/api/remote/CounterService;)V", "add", "Lio/reactivex/Completable;", "title", "", "counters", "Lio/reactivex/Single;", "", "Lcom/example/counterservice/model/Counter;", "createIdMap", "Ljava/util/HashMap;", "id", "decrement", "delete", "increment", "sumOfCounters", "", "counterservice_debug"})
@kotlinx.serialization.ExperimentalSerializationApi()
public final class CounterRemoteDataSource implements com.example.counterservice.api.CounterDataSource {
    private final com.example.counterservice.api.remote.CounterService service = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable add(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable increment(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable decrement(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable delete(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.example.counterservice.model.Counter>> counters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Integer> sumOfCounters() {
        return null;
    }
    
    private final java.util.HashMap<java.lang.String, java.lang.String> createIdMap(java.lang.String id) {
        return null;
    }
    
    public CounterRemoteDataSource(@org.jetbrains.annotations.NotNull()
    com.example.counterservice.api.remote.CounterService service) {
        super();
    }
}