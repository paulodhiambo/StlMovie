package com.stlhorizon.stlmovie.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.stlhorizon.stlmovie.data.local.AppDatabase
import com.stlhorizon.stlmovie.data.remote.StlAPI
import com.stlhorizon.stlmovie.data.remote.TokenInterceptor
import com.stlhorizon.stlmovie.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson =
        GsonBuilder()
            .create()


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder =
        Retrofit.Builder()
            .client(provideInterceptor())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))


    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit.Builder): StlAPI =
        retrofit
            .build()
            .create(StlAPI::class.java)


    @Singleton
    @Provides
    fun provideInterceptor(): OkHttpClient {
        val interceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideMovieDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "stlmovies.db"
    ).build()

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase) =
        db.movieDao()
}