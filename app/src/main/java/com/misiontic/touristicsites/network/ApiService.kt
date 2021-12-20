package com.misiontic.touristicsites.network

import com.misiontic.touristicsites.data.ModelSites
import retrofit2.http.GET

interface ApiService {
    @GET("sites")
    suspend fun getAllSites(): List<ModelSites>
}