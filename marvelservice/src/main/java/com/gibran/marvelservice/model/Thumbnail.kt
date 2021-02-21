package com.gibran.marvelservice.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Entity(tableName = Thumbnail.TABLE_NAME)
@Parcelize
@Serializable
data class Thumbnail(
    val extension: String,
    val path: String
) : Parcelable {
    companion object {
        internal const val TABLE_NAME = "thumbnail"
    }
}