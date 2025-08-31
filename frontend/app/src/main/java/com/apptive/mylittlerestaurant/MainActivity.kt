package com.apptive.mylittlerestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.apptive.mylittlerestaurant.navigation.NavGraph
import com.apptive.mylittlerestaurant.ui.theme.MyLittleRestaurantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLittleRestaurantTheme {
                NavGraph()
            }
        }
    }
}
