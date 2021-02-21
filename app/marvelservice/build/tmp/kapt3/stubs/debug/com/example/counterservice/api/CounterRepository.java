package com.example.counterservice.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001e0\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0016\u0010#\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eH\u0002J\u0016\u0010$\u001a\u00020%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eH\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dH\u0016R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR@\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/counterservice/api/CounterRepository;", "Lcom/example/counterservice/api/CounterDataSource;", "remoteRepo", "localRepo", "Lcom/example/counterservice/api/local/CounterDatabaseDataSource;", "(Lcom/example/counterservice/api/CounterDataSource;Lcom/example/counterservice/api/local/CounterDatabaseDataSource;)V", "cacheIsDirty", "", "getCacheIsDirty$annotations", "()V", "getCacheIsDirty", "()Z", "setCacheIsDirty", "(Z)V", "cachedCounters", "Ljava/util/LinkedHashMap;", "", "Lcom/example/counterservice/model/Counter;", "Lkotlin/collections/LinkedHashMap;", "getCachedCounters$annotations", "getCachedCounters", "()Ljava/util/LinkedHashMap;", "setCachedCounters", "(Ljava/util/LinkedHashMap;)V", "add", "Lio/reactivex/Completable;", "title", "", "counters", "Lio/reactivex/Single;", "", "decrement", "id", "delete", "increment", "refreshLocalDataSource", "refreshMemoryCache", "", "sumOfCounters", "counterservice_debug"})
public final class CounterRepository implements com.example.counterservice.api.CounterDataSource {
    @org.jetbrains.annotations.NotNull()
    private java.util.LinkedHashMap<java.lang.Integer, com.example.counterservice.model.Counter> cachedCounters;
    private boolean cacheIsDirty = true;
    private final com.example.counterservice.api.CounterDataSource remoteRepo = null;
    private final com.example.counterservice.api.local.CounterDatabaseDataSource localRepo = null;
    
    @androidx.annotation.VisibleForTesting()
    @java.lang.Deprecated()
    public static void getCachedCounters$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.LinkedHashMap<java.lang.Integer, com.example.counterservice.model.Counter> getCachedCounters() {
        return null;
    }
    
    public final void setCachedCounters(@org.jetbrains.annotations.NotNull()
    java.util.LinkedHashMap<java.lang.Integer, com.example.counterservice.model.Counter> p0) {
    }
    
    @androidx.annotation.VisibleForTesting()
    @java.lang.Deprecated()
    public static void getCacheIsDirty$annotations() {
    }
    
    public final boolean getCacheIsDirty() {
        return false;
    }
    
    public final void setCacheIsDirty(boolean p0) {
    }
    
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
    
    private final void refreshMemoryCache(java.util.List<com.example.counterservice.model.Counter> counters) {
    }
    
    private final io.reactivex.Completable refreshLocalDataSource(java.util.List<com.example.counterservice.model.Counter> counters) {
        return null;
    }
    
    public CounterRepository(@org.jetbrains.annotations.NotNull()
    com.example.counterservice.api.CounterDataSource remoteRepo, @org.jetbrains.annotations.NotNull()
    com.example.counterservice.api.local.CounterDatabaseDataSource localRepo) {
        super();
    }
}