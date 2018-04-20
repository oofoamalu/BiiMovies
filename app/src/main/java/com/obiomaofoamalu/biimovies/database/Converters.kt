package com.obiomaofoamalu.biimovies.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val mGson: Gson = Gson()

    @TypeConverter
    fun serializeIntegerList(list: ArrayList<Int>) = mGson.toJson(list)

    @TypeConverter
    fun deserializeIntegerList(serializedList: String): ArrayList<Int> =
            mGson.fromJson(serializedList, object : TypeToken<ArrayList<Int>>() {}.type)

    @TypeConverter
    fun serializeStringList(list: ArrayList<String>) = mGson.toJson(list)

    @TypeConverter
    fun deserializeStringList(serializedList: String): ArrayList<String> =
            mGson.fromJson(serializedList, object : TypeToken<ArrayList<String>>() {}.type)
}