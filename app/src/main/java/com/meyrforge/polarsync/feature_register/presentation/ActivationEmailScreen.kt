package com.meyrforge.polarsync.feature_register.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meyrforge.polarsync.R
import com.meyrforge.polarsync.Screen
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Composable
fun ActivationEmailScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(DeepPurple),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(id = R.drawable.polarsync_logo), "logo")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hemos enviado un correo de activación a su email para que pueda acceder a PolarSync",
                color = PowderedPink,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent("Aceptar") { navController.navigate(Screen.LoginScreen.route) }
        }
    }
}