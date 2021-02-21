package com.gibran.marvelservice.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Entity(tableName = Item.TABLE_NAME)
@Parcelize
@Serializable
data class Item(
    val name: String,
    val resourceURI: String
) : Parcelable {
    companion object {
        internal const val TABLE_NAME = "item"
    }
}