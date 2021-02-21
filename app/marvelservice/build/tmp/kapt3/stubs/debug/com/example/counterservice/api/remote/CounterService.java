package com.example.counterservice.api.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\'J.\u0010\f\u001a\u00020\u00032$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\'J.\u0010\u000e\u001a\u00020\u00032$\b\u0001\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\'J.\u0010\u0010\u001a\u00020\u00032$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007H\'J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/counterservice/api/remote/CounterService;", "", "add", "Lio/reactivex/Completable;", "title", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "counters", "Lio/reactivex/Single;", "", "Lcom/example/counterservice/model/Counter;", "decrement", "id", "delete", "body", "increment", "sumOfCounter", "", "counterservice_debug"})
public abstract interface CounterService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "counters")
    public abstract io.reactivex.Single<java.util.List<com.example.counterservice.model.Counter>> counters();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "counter")
    public abstract io.reactivex.Completable add(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> title);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "counter/inc")
    public abstract io.reactivex.Completable increment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "counter/dec")
    public abstract io.reactivex.Completable decrement(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.HTTP(method = "DELETE", path = "counter", hasBody = true)
    public abstract io.reactivex.Completable delete(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> body);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "sum")
    public abstract io.reactivex.Single<java.lang.Integer> sumOfCounter();
}