package com.example.horodcopoapp.data.network

import com.example.horodcopoapp.BuildConfig.API_KEY
import com.example.horodcopoapp.data.RepositoryImp
import com.example.horodcopoapp.data.core.interceptors.AuthInterceptor
import com.example.horodcopoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(OkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_KEY)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    //interceptor per recuperear la resposta de la API
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
       return OkHttpClient
           .Builder()
           .addInterceptor(interceptor)
           .addInterceptor(authInterceptor)
           .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository {
        return RepositoryImp(apiService)
    }


}