package com.example.socialapp.di

import com.example.socialapp.data.clode.service.LoginService
import com.example.socialapp.data.clode.service.PostService
import com.example.socialapp.data.clode.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://parseapi.back4app.com/classes/"
private const val APPLICATION_ID = "MS8t4OdSezeoWuYyhKlsq56gk5pexahC47apQmHN"
private const val REST_API_KYE = "fa32NaEjKbyI2TM2Fh03LBI7sEga0chAvJNynsfP"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(Interceptor { chain ->
                        val request = chain.request()
                            .newBuilder()
                            .addHeader(
                                name = "X-Parse-Application-Id",
                                value = APPLICATION_ID
                            )
                            .addHeader(
                                name = "X-Parse-REST-API-Key",
                                value = REST_API_KYE
                            )
                            .addHeader(
                                name = "Content-Type",
                                value = "application/json"
                            )
                            .build()
                        return@Interceptor chain.proceed(request = request)
                    }).build()
            ).build()
    }

    @Provides
    fun provideLoginService(
        retrofit: Retrofit
    ): LoginService = retrofit.create(LoginService::class.java)

    @Provides
    fun provideUserService(
        retrofit: Retrofit
    ): UserService = retrofit.create(UserService::class.java)

    @Provides
    fun providePostService(
        retrofit: Retrofit
    ): PostService = retrofit.create(PostService::class.java)
}