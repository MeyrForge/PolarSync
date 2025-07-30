package com.meyrforge.polarsync.feature_moods.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meyrforge.polarsync.feature_moods.presentation.components.MoodSelectionComponent
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.orange
import com.meyrforge.polarsync.ui.theme.petroleum
import com.meyrforge.polarsync.ui.theme.pink
import com.meyrforge.polarsync.ui.theme.purple

@Preview
@Composable
fun MoodSelectionScreen(viewModel: MoodSelectionViewModel = hiltViewModel()) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
    ) {
        item {
            TopSemicircleItem("Seguimiento del Ánimo")
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            Column(modifier = Modifier.padding(20.dp)) {
                MoodSelectionComponent(
                    viewModel.highestMoodChosen.value ?: "",
                    pink,
                    "Ánimo más elevado",
                    viewModel::onHighestMoodChosen
                )
                MoodSelectionComponent(
                    viewModel.irritableMoodChosen.value ?: "",
                    orange,
                    "Ánimo más irritable",
                    viewModel::onIrritableMoodChosen
                )
                MoodSelectionComponent(
                    viewModel.anxiousMoodChosen.value ?: "",
                    purple,
                    "Ánimo más ansioso",
                    viewModel::onAnxiousMoodChosen
                )
                MoodSelectionComponent(
                    viewModel.depressedMoodChosen.value ?: "",
                    petroleum,
                    "Ánimo más depresivo",
                    viewModel::onDepressedMoodChosen
                )
            }
        }
        item {
            Box(modifier = Modifier.padding(15.dp)) {
                ButtonComponent("Guardar") { viewModel.onSaveMoods() }
            }
        }
    }
}