package com.gibran.marvelservice.database.converter

import androidx.room.TypeConverter
import com.gibran.marvelservice.model.Item
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromItemList(value: List<Item>) = Json.encodeToString(value)

    @TypeConverter
    fun toItemList(value: String) = Json.decodeFromString<List<Item>>(value)
}