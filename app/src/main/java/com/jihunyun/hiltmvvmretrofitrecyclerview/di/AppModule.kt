package com.jihunyun.hiltmvvmretrofitrecyclerview.di

import com.jihunyun.hiltmvvmretrofitrecyclerview.network.ApiService
import com.jihunyun.hiltmvvmretrofitrecyclerview.repository.MainRepository
import com.jihunyun.hiltmvvmretrofitrecyclerview.usecase.MainUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesMainUseCase(repository: MainRepository) = MainUseCase(repository)

    @Provides
    fun providesMainRepository(apiService: ApiService): MainRepository = MainRepository(apiService)

    @Provides
    fun providesRetrofitBuilder(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesBaseUrl(): String = "https://02e6dc2c-cca0-4c94-ac25-76644dc7d3d6.mock.pstmn.io"

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}