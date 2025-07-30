package com.meyrforge.polarsync.feature_moods.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
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
    val highestMood by viewModel.highestMoodChosen
    val irritableMood by viewModel.irritableMoodChosen
    val anxiousMood by viewModel.anxiousMoodChosen
    val depressedMood by viewModel.depressedMoodChosen
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepPurple)
                .padding(paddingValues)
        ) {
            item {
                TopSemicircleItem("Seguimiento del Ánimo")
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Column(modifier = Modifier.padding(20.dp)) {
                    MoodSelectionComponent(
                        highestMood,
                        pink,
                        "Ánimo más elevado",
                        viewModel::onHighestMoodChosen
                    )
                    MoodSelectionComponent(
                        irritableMood,
                        orange,
                        "Ánimo más irritable",
                        viewModel::onIrritableMoodChosen
                    )
                    MoodSelectionComponent(
                        anxiousMood,
                        purple,
                        "Ánimo más ansioso",
                        viewModel::onAnxiousMoodChosen
                    )
                    MoodSelectionComponent(
                        depressedMood,
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
        NotificationSnackbar(viewModel, snackbarHostState)
    }
}


@Composable
fun NotificationSnackbar(viewModel: MoodSelectionViewModel, snackbarHostState: SnackbarHostState){
    val notificationMessage by viewModel.notificationMessage.observeAsState()

    LaunchedEffect(notificationMessage) {
        notificationMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearMessage()
        }
    }
}