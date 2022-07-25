package com.example.androidbootcampodev7.di

import android.content.Context
import androidx.room.Room
import com.example.androidbootcampodev7.data.repo.YapilacaklarDaoRepository
import com.example.androidbootcampodev7.room.VeriTabani
import com.example.androidbootcampodev7.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton

    fun provideYapilacaklarDaoRepository(ydao:YapilacaklarDao) : YapilacaklarDaoRepository{
        return  YapilacaklarDaoRepository(ydao)
    }

    @Provides
    @Singleton

    fun provideYapilacaklarDao(@ApplicationContext context: Context) : YapilacaklarDao{
        val vt = Room.databaseBuilder(context, VeriTabani::class.java, "todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}