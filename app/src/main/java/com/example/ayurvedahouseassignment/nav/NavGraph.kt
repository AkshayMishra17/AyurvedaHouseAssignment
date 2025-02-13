package com.example.ayurvedahouseassignment.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ayurvedahouseassignment.screen.CartScreen
import com.example.ayurvedahouseassignment.screen.ProductDetailScreen
import com.example.ayurvedahouseassignment.screen.ProductListScreen
import com.example.ayurvedahouseassignment.vm.ProductViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: ProductViewModel) {
    NavHost(navController, startDestination = "product_list") {
        composable("product_list") {
            ProductListScreen(
                navController = navController,
                products = viewModel.products.value,
                cartItems = viewModel.cartItems.value,
                updateCart = viewModel::updateCart,
                onProductClick = { productId ->
                    navController.navigate("product_detail/$productId")
                }
            )
        }
        composable("product_detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            val product = viewModel.products.value.find { it.id == productId }

            if (product != null) {
                ProductDetailScreen(
                    product = product,
                    cartItems = viewModel.cartItems.value,
                    updateCart = viewModel::updateCart,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
        composable("cart") {
            CartScreen(
                cartItems = viewModel.cartItems.value,
                products = viewModel.products.value,
                updateCart = viewModel::updateCart,
                onBackClick = { navController.popBackStack() }
            )
        }

    }
}
