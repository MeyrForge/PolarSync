package com.meyrforge.polarsync.feature_login.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander

@Composable
fun InputFieldComponent(
    text: String,
    keyboardType: KeyboardType,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text, fontSize = 18.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = PowderedPink,
            unfocusedBorderColor = PowderedPink,
            unfocusedLabelColor = PowderedPink,
            unfocusedLeadingIconColor = PowderedPink,
            focusedBorderColor = SoftBlueLavander,
            focusedLabelColor = SoftBlueLavander,
            focusedTextColor = SoftBlueLavander
        ),
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
    )
}