package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.data.manager.LocalUserManagerImplementation
import com.example.myapplication.domain.manager.LocalUserManager
import com.example.myapplication.domain.manager.usecases.AppEntryUsecases
import com.example.myapplication.domain.manager.usecases.ReadAppEntry
import com.example.myapplication.domain.manager.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUsecases(localUserManager: LocalUserManager) =
        AppEntryUsecases(readAppEntry = ReadAppEntry(localUserManager), saveAppEntry = SaveAppEntry(localUserManager))
}