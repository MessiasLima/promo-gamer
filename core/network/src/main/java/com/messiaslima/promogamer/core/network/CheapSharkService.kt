package com.messiaslima.promogamer.core.network

import com.messiaslima.promogamer.core.network.deal.DealResponse
import com.messiaslima.promogamer.core.network.store.StoreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CheapSharkService {
    @SuppressWarnings("LongParameterList")
    @GET("/api/1.0/deals")
    suspend fun getDeals(
        @Query("storeID") storeId: Int? = null,
        @Query("pageNumber") pageNumber: Int? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("desc") desc: Int? = null,
        @Query("lowerPrice") lowerPrice: Int? = null,
        @Query("upperPrice") upperPrice: Int? = null,
        @Query("metacritic") metacritic: Int? = null,
        @Query("steamRating") steamRating: Int? = null,
        @Query("steamAppID") steamAppId: String? = null,
        @Query("title") title: String? = null,
        @Query("exact") exact: Int? = null,
        @Query("AAA") aaa: Int? = null,
        @Query("steamworks") steamworks: Int? = null,
        @Query("onSale") onSale: Int? = null,
    ): Response<List<DealResponse>>

    @GET("/api/1.0/stores")
    suspend fun getStores(): Response<List<StoreResponse>>
}
