package com.example.cleanarchitecturesample.di

import com.example.cleanarchitecturesample.util.Constants
import com.example.data.remote.ArticlesApi
import com.example.data.repository.ArticlesRepositoryImpl
import com.example.domain.repository.ArticlesRepository
import com.example.domain.usecases.GetArticlesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        val level = logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(level).build()
    }

    @Singleton
    @Provides
    fun provideRetrofitForArticlesApi(client: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL_SPACEFLIGHT)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    @Provides
    @Singleton
    fun provideArticlesApi(retrofit: Retrofit): ArticlesApi {
        return retrofit.create(ArticlesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideArticlesRepository(api: ArticlesApi): ArticlesRepository {
        return ArticlesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetArticlesUseCase(repository: ArticlesRepository): GetArticlesUseCase {
        return GetArticlesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}
