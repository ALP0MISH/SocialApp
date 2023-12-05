package com.example.socialapp.di

import com.example.socialapp.data.repositories.CurrentUserRepositoryImpl
import com.example.socialapp.data.repositories.LoginRepositoryImpl
import com.example.socialapp.data.repositories.PostRepositoryImpl
import com.example.socialapp.data.repositories.UserRepositoryImpl
import com.example.socialapp.domain.repositories.CurrentUserRepository
import com.example.socialapp.domain.repositories.LoginRepository
import com.example.socialapp.domain.repositories.PostRepository
import com.example.socialapp.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindLoginRepository(
        impl: LoginRepositoryImpl
    ): LoginRepository

    @Binds
    fun bindCurrentUserRepository(
        impl: CurrentUserRepositoryImpl
    ): CurrentUserRepository

    @Binds
    fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    fun bindPostRepository(
        impl: PostRepositoryImpl
    ): PostRepository


}