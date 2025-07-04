package com.meyrforge.polarsync.feature_login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.meyrforge.polarsync.R
import com.meyrforge.polarsync.Screen
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.shared.InputFieldComponent
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Composable
fun LoginScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        item {
            Image(painterResource(id = R.drawable.polarsync_logo), "logo")
        }
        item {
            InputFieldComponent("Email", KeyboardType.Email, "") {}
        }
        item {
            InputFieldComponent("Contraseña", KeyboardType.Password, "") {}
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                ButtonComponent("Iniciar sesión"){navController.navigate(Screen.HomeScreen.route)}
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No tengo cuenta, registrarme",
                    color = PowderedPink,
                    modifier = Modifier.clickable {
                        navController.navigate(
                            Screen.RegisterScreen.route
                        )
                    })
            }
        }
    }
}