package com.meyrforge.polarsync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.meyrforge.polarsync.feature_login.presentation.LoginScreen
import com.meyrforge.polarsync.ui.theme.PolarSyncTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolarSyncTheme {
                LoginScreen()
            }
        }
    }
}
