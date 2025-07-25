package com.meyrforge.polarsync.feature_medication.presentation.components

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
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
    ) {
        item { TopSemicircleItem("Seguimiento de medicacion") }
        item { PolyTalkItem() }
        item { DateComponent() }
        item { MedicationEditCheckboxComponent("Medicacion 120", true) }
        item { MedicationEditCheckboxComponent("Medicacion 2", false) }
        item {
            Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)) {
                ButtonComponent("Agregar medicacion") { }
            }
        }
        item {
            Box(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .align(Alignment.BottomEnd),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PowderedPink,
                        contentColor = DeepPurple
                    )
                ) { Text("Guardar") }
            }
        }
    }
}