package com.meyrforge.polarsync.feature_home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AssignmentInd
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Mood
import androidx.compose.material.icons.outlined.Nightlight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.green
import com.meyrforge.polarsync.ui.theme.orange
import com.meyrforge.polarsync.ui.theme.pink
import com.meyrforge.polarsync.ui.theme.purple

@Preview(showBackground = true)
@Composable
fun HomeScreenComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
            item { TopSemicircleItem() }
            item { PolyTalkItem() }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                Text(
                    text = "Seguimientos:",
                    fontSize = 18.sp,
                    color = PowderedPink,
                    modifier = Modifier.padding(4.dp)
                )
            }
            item {}
            item { FeatureItemComponent(Icons.Outlined.Mood, "Estados de ánimo", orange) }
            item { FeatureItemComponent(Icons.Outlined.Medication, "Medicación", green) }
            item { FeatureItemComponent(Icons.Outlined.Nightlight, "Sueño", purple) }
            item { FeatureItemComponent(Icons.Outlined.AssignmentInd, "Terapia", pink) }
        }
    }
}