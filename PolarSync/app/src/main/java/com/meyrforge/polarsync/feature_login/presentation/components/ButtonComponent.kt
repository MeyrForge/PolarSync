package com.meyrforge.polarsync.feature_login.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Preview(showBackground = true, backgroundColor = 0xFF5C5470)
@Composable
fun ButtonComponent(){
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = PowderedPink, contentColor = DeepPurple)) {
        Text("Iniciar sesión")
    }
}