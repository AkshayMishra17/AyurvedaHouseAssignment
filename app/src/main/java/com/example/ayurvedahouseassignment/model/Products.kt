package com.example.ayurvedahouseassignment.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val image: String,
    val description:String,
    var quantity: Int = 0
)

