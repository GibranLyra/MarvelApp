package com.example.counterservice.api.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/counterservice/api/local/CounterLocalDataSource;", "Lcom/example/counterservice/api/local/CounterDatabaseDataSource;", "heroDao", "Lcom/example/counterservice/database/dao/CounterDao;", "(Lcom/example/counterservice/database/dao/CounterDao;)V", "counters", "Lio/reactivex/Single;", "", "Lcom/example/counterservice/model/Counter;", "counterservice_debug"})
public final class CounterLocalDataSource implements com.example.counterservice.api.local.CounterDatabaseDataSource {
    private final com.example.counterservice.database.dao.CounterDao counterDao = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.counterservice.database.dao.CounterDao counterDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.example.counterservice.model.Counter>> counters() {
        return null;
    }
    
    public CounterLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.counterservice.database.dao.CounterDao counterDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable add(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
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
    public io.reactivex.Completable increment(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Integer> sumOfCounters() {
        return null;
    }
}