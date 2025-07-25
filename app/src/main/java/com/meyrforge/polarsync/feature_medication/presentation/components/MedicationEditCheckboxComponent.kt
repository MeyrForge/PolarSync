package com.meyrforge.polarsync.feature_medication.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Composable
fun MedicationEditCheckboxComponent(medication: String, wasTaken: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(medication, fontSize = 18.sp, color = PowderedPink, modifier = Modifier.weight(8f))
        Icon(Icons.Outlined.Edit, "Editar", tint = PowderedPink, modifier = Modifier.weight(1f))
        Checkbox(
            wasTaken,
            {},
            modifier = Modifier.weight(1f),
            colors = CheckboxDefaults.colors(checkedColor = PowderedPink)
        )
    }
}