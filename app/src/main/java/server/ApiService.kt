package server

import adapter.ModelSites
import retrofit2.http.GET

interface ApiService {
    @GET("sites")
    suspend fun getAllSites(): List<ModelSites>
}