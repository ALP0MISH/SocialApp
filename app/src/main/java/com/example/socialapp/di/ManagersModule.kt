package com.example.socialapp.di

import com.example.socialapp.presentation.managers.ShowToastUseCase
import com.example.socialapp.presentation.managers.ToastManager
import com.example.socialapp.presentation.navigation.GlobalNavigatorManager
import com.example.socialapp.presentation.navigation.NavigatorManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ManagersModule {

    @Binds
    @Singleton
    fun bindNavigatorManager(
        impl: NavigatorManagerImpl
    ): GlobalNavigatorManager

    @Binds
    @Singleton
    fun bindShowToastUseCase(
        impl: ToastManager
    ): ShowToastUseCase

}