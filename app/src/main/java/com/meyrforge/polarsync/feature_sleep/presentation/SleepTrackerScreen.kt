package com.meyrforge.polarsync.feature_sleep.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meyrforge.polarsync.feature_sleep.presentation.components.AddNotesComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.HoursSliderComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.QuestionWithSegmentedButtonComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.WentToSleepClockComponent
import com.meyrforge.polarsync.ui.shared.DateComponent
import com.meyrforge.polarsync.ui.shared.PolyTalkItem
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple

@Preview
@Composable
fun SleepTrackerScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
    ) {
        item {
            TopSemicircleItem("Seguimiento del sueño")
        }
        item {
            PolyTalkItem()
        }
        item { DateComponent() }
        item { HoursSliderComponent(10f) {} }
        item { WentToSleepClockComponent() }
        item { QuestionWithSegmentedButtonComponent("Tuviste pensamientos negativos?") }
        item { QuestionWithSegmentedButtonComponent("Estuviste ansioso antes de dormir?") }
        item { QuestionWithSegmentedButtonComponent("Dormiste de corrido?") }
        item { AddNotesComponent() }

    }
}