package com.gibran.marvelservice.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Entity(tableName = Hero.TABLE_NAME)
@Parcelize
@Serializable
data class Hero(
    @Embedded(prefix = "comics")
    val comics: DataEntity,
    val description: String,
    @Embedded(prefix = "events")
    val events: DataEntity,
    @PrimaryKey
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    @Embedded(prefix = "series")
    val series: DataEntity,
    @Embedded(prefix = "stories")
    val stories: DataEntity,
    @Embedded
    val thumbnail: Thumbnail
) : Parcelable {
    companion object {
        internal const val TABLE_NAME = "heroes"
    }
}