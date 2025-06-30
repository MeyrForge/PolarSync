package com.meyrforge.polarsync.feature_register.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.meyrforge.polarsync.Screen
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.shared.InputFieldComponent
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple

@Composable
fun RegisterScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
    ) {
        TopSemicircleItem("Registro")
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            item { InputFieldComponent("Nombre", KeyboardType.Text, "") { } }
            item { InputFieldComponent("Email", KeyboardType.Text, "") { } }
            item { InputFieldComponent("Contraseña", KeyboardType.Password, "") { } }
            item { InputFieldComponent("Reptir contraseña", KeyboardType.Password, "") { } }
            item {
                Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                ButtonComponent("Registrarse"){navController.navigate(Screen.ActivationEmailScreen.route)}
            } }
        }
    }
}