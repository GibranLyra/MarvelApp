package com.example.counterservice.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/example/counterservice/api/CounterDataSource;", "", "add", "Lio/reactivex/Completable;", "title", "", "counters", "Lio/reactivex/Single;", "", "Lcom/example/counterservice/model/Counter;", "decrement", "id", "delete", "increment", "sumOfCounters", "", "counterservice_debug"})
public abstract interface CounterDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable add(@org.jetbrains.annotations.NotNull()
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable increment(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable decrement(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable delete(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.example.counterservice.model.Counter>> counters();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Integer> sumOfCounters();
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Completable add(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.CounterDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Completable increment(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.CounterDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Completable decrement(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.CounterDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Completable delete(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.CounterDataSource $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Single<java.lang.Integer> sumOfCounters(@org.jetbrains.annotations.NotNull()
        com.example.counterservice.api.CounterDataSource $this) {
            return null;
        }
    }
}