package com.meyrforge.polarsync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meyrforge.polarsync.feature_home.presentation.HomeScreen
import com.meyrforge.polarsync.feature_login.presentation.LoginScreen
import com.meyrforge.polarsync.feature_medication.presentation.MedicationScreen
import com.meyrforge.polarsync.feature_moods.presentation.MoodSelectionScreen
import com.meyrforge.polarsync.feature_register.presentation.ActivationEmailScreen
import com.meyrforge.polarsync.feature_register.presentation.RegisterScreen
import com.meyrforge.polarsync.feature_sleep.presentation.SleepTrackerScreen
import com.meyrforge.polarsync.ui.theme.PolarSyncTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolarSyncTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.LoginScreen.route
                ){
                    composable(route = Screen.LoginScreen.route) {
                        LoginScreen(navController)
                    }
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen(navController)
                    }
                    composable(route = Screen.RegisterScreen.route) {
                        RegisterScreen(navController)
                    }
                    composable(route = Screen.ActivationEmailScreen.route) {
                        ActivationEmailScreen(navController)
                    }
                    composable(route = Screen.MoodSelectionScreen.route) {
                        MoodSelectionScreen()
                    }
                    composable(route = Screen.SleepTrackerScreen.route){
                        SleepTrackerScreen()
                    }
                    composable(route = Screen.MedicationTrackerScreen.route){
                        MedicationScreen()
                    }
                }
            }
        }
    }
}
