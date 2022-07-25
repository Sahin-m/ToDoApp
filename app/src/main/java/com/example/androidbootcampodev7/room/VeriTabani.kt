package com.example.androidbootcampodev7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidbootcampodev7.data.entity.Yapilacaklar

@Database(entities = [Yapilacaklar::class], version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun  getYapilacaklarDao() : YapilacaklarDao
}