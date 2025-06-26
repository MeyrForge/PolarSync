package com.meyrforge.polarsync.feature_login.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meyrforge.polarsync.R
import com.meyrforge.polarsync.ui.theme.DeepPurple

@Preview
@Composable
fun LoginScreen() {
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
                ButtonComponent()
            }
        }
    }
}