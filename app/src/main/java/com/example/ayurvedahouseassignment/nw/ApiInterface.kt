package com.example.ayurvedahouseassignment.nw

import com.example.ayurvedahouseassignment.model.Product
import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}
