package com.gibran.marvelservice.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class MarvelData<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @Contextual
    val data: Data<T>,
    val etag: String,
    val status: String
)