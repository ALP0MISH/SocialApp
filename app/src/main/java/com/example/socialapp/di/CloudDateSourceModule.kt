package com.example.socialapp.di

import com.example.socialapp.data.clode.source.PostCloudDataSource
import com.example.socialapp.data.clode.source.PostCloudDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CloudDateSourceModule {

    @Binds
    fun bindPostCloudDataSource(
        implementation: PostCloudDataSourceImpl
    ): PostCloudDataSource
}