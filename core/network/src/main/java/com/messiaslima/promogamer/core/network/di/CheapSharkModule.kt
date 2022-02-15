package com.messiaslima.promogamer.core.network.di

import com.messiaslima.promogamer.core.network.CheapSharkService
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@DisableInstallInCheck
@Module
object CheapSharkModule {
    private const val BASE_URL = "https://www.cheapshark.com"

    @Provides
    fun provideCheapSharkService(): CheapSharkService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CheapSharkService::class.java)
    }
}
