package com.meyrforge.polarsync.feature_medication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meyrforge.polarsync.feature_medication.presentation.components.MedicationEditCheckboxComponent
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.shared.DateComponent
import com.meyrforge.polarsync.ui.shared.PolyTalkItem
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Preview
@Composable
fun MedicationScreen() {
    LazyColumn(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(DeepPurple)
    ) {
        item { TopSemicircleItem("Seguimiento de medicación") }
        item { PolyTalkItem() }
        item { DateComponent() }
        item { MedicationEditCheckboxComponent("Medicación 120") {} }
        item { MedicationEditCheckboxComponent("Medicación 2") {} }
        item {
            Box(modifier = Modifier.Companion.padding(horizontal = 20.dp, vertical = 6.dp)) {
                ButtonComponent("Agregar medicación") { }
            }
        }
        item {
            Box(modifier = Modifier.Companion.fillMaxSize()) {
                Button(
                    onClick = {},
                    modifier = Modifier.Companion
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .align(Alignment.Companion.BottomEnd),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PowderedPink,
                        contentColor = DeepPurple
                    )
                ) { Text("Guardar") }
            }
        }
    }
}