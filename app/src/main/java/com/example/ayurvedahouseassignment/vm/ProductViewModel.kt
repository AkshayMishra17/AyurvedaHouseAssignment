package com.example.ayurvedahouseassignment.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.ayurvedahouseassignment.model.Product
import com.example.ayurvedahouseassignment.nw.RetrofitInstance

class ProductViewModel : ViewModel() {
    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    private val _cartItems = mutableStateOf<Map<Int, Int>>(emptyMap())
    val cartItems: State<Map<Int, Int>> = _cartItems
    init {
        fetchProducts()
    }
    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts()
                _products.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun updateCart(productId: Int, quantity: Int) {
        val currentCart = _cartItems.value.toMutableMap()

        if (quantity > 0) {
            currentCart[productId] = quantity
        } else {
            currentCart.remove(productId)
        }
        _cartItems.value = currentCart
    }
}
