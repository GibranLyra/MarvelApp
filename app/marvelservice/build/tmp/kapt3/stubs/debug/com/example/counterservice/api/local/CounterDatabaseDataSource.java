package com.example.counterservice.api.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/counterservice/api/local/CounterDatabaseDataSource;", "Lcom/example/counterservice/api/CounterDataSource;", "heroDao", "Lcom/example/counterservice/database/dao/CounterDao;", "counterservice_debug"})
public abstract interface CounterDatabaseDataSource extends com.example.counterservice.api.CounterDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.counterservice.database.dao.CounterDao counterDao();
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static io.reactivex.Completable add(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.local.CounterDatabaseDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static io.reactivex.Completable decrement(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.local.CounterDatabaseDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static io.reactivex.Completable delete(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.local.CounterDatabaseDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static io.reactivex.Completable increment(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.local.CounterDatabaseDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static io.reactivex.Single<java.lang.Integer> sumOfCounters(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.local.CounterDatabaseDataSource $this) {
            return null;
        }
    }
}