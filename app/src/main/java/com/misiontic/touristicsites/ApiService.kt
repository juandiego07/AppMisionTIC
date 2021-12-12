package com.misiontic.touristicsites

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("sites")
    suspend fun getAllSites(): List<ModelSites>
}