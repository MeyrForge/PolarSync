package com.meyrforge.polarsync.feature_sleep.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander

@Preview
@Composable
fun AddNotesComponent() {
    OutlinedTextField(
        "",
        {},
        modifier = Modifier.fillMaxWidth().height(120.dp).padding(horizontal = 20.dp),
        label = { Text("Notas adicionales")},
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = PowderedPink,
            unfocusedBorderColor = PowderedPink,
            unfocusedLabelColor = PowderedPink,
            unfocusedLeadingIconColor = PowderedPink,
            focusedBorderColor = SoftBlueLavander,
            focusedLabelColor = SoftBlueLavander,
            focusedTextColor = SoftBlueLavander
        ))
}