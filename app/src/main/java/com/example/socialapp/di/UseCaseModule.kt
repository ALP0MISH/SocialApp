package com.example.socialapp.di

import com.example.socialapp.data.clode.service.LoginService
import com.example.socialapp.data.repositories.MenuRepository
import com.example.socialapp.data.repositories.MenuRepositoryImpl
import com.example.socialapp.domain.repositories.CurrentUserRepository
import com.example.socialapp.domain.repositories.LoginRepository
import com.example.socialapp.domain.repositories.PostRepository
import com.example.socialapp.domain.repositories.UserRepository
import com.example.socialapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.example.socialapp.domain.usecases.current_user.FetchCurrentUserImpl
import com.example.socialapp.domain.usecases.current_user.IsOnboardingPassedUseCase
import com.example.socialapp.domain.usecases.current_user.IsOnboardingPassedUseCaseImpl
import com.example.socialapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.example.socialapp.domain.usecases.current_user.SaveCurrentUserUseCaseImpl
import com.example.socialapp.domain.usecases.current_user.SetOnboardingShowedUseCase
import com.example.socialapp.domain.usecases.current_user.SetOnboardingShowedUseCaseImpl
import com.example.socialapp.domain.usecases.post.FetchAllPostUseCase
import com.example.socialapp.domain.usecases.post.FetchAllPostUseCaseImpl
import com.example.socialapp.domain.usecases.signIn.SignInUseCase
import com.example.socialapp.domain.usecases.signIn.SignInUseCaseImpl
import com.example.socialapp.domain.usecases.sign_up.SignUPUseCase
import com.example.socialapp.domain.usecases.sign_up.SignUPUseCaseImpl
import com.example.socialapp.domain.usecases.users.FetchAllUsersUseCase
import com.example.socialapp.domain.usecases.users.FetchAllUsersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideSignInUseCase(
        repository: LoginRepository
    ): SignInUseCase = SignInUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSignUPUseCase(
        repository: LoginRepository,
        userRepository: UserRepository
    ): SignUPUseCase = SignUPUseCaseImpl(
        repository = repository,
        userRepository = userRepository
    )

    @Provides
    fun provideFetchCurrentUserUseCase(
        repository: CurrentUserRepository
    ): FetchCurrentUserUseCase = FetchCurrentUserImpl(
        repository = repository
    )

    @Provides
    fun provideIsOnboardingPassedUseCase(
        repository: CurrentUserRepository
    ): IsOnboardingPassedUseCase = IsOnboardingPassedUseCaseImpl(
        currentUserRepository = repository
    )

    @Provides
    fun provideSaveCurrentUserUseCase(
        repository: CurrentUserRepository
    ): SaveCurrentUserUseCase = SaveCurrentUserUseCaseImpl(
        currentUserRepository = repository
    )

    @Provides
    fun provideSetOnboardingShowedUseCase(
        repository: CurrentUserRepository
    ): SetOnboardingShowedUseCase = SetOnboardingShowedUseCaseImpl(
        currentUserRepository = repository
    )

    @Provides
    fun provideFetchAllUsersUseCase(
        repository: CurrentUserRepository,
        userRepository: UserRepository
    ): FetchAllUsersUseCase = FetchAllUsersUseCaseImpl(
        currentUserRepository = repository,
        userRepository = userRepository
    )

    @Provides
    fun provideFetchAllPostUseCase(
        postRepository: PostRepository,
        currentUserRepository: CurrentUserRepository
    ): FetchAllPostUseCase = FetchAllPostUseCaseImpl(
        postRepository = postRepository,
        currentUserRepository = currentUserRepository
    )
}