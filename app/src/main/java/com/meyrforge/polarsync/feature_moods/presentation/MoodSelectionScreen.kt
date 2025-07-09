package com.meyrforge.polarsync.feature_moods.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meyrforge.polarsync.feature_moods.presentation.components.MoodSelectionComponent
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.orange
import com.meyrforge.polarsync.ui.theme.petroleum
import com.meyrforge.polarsync.ui.theme.pink
import com.meyrforge.polarsync.ui.theme.purple

@Preview
@Composable
fun MoodSelectionScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().background(DeepPurple)) {
        item {
            TopSemicircleItem("Seguimiento del Ánimo")
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            MoodSelectionComponent(pink, "Ánimo más elevado")
            MoodSelectionComponent(orange, "Ánimo más irritable")
            MoodSelectionComponent(purple, "Ánimo más ansioso")
            MoodSelectionComponent(petroleum, "Ánimo más depresivo")

        }
    }
}