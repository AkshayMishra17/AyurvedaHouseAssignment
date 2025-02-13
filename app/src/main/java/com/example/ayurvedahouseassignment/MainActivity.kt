package com.example.ayurvedahouseassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.ayurvedahouseassignment.nav.NavGraph
import com.example.ayurvedahouseassignment.vm.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: ProductViewModel = viewModel()
            NavGraph(navController, viewModel)
        }
    }
}
