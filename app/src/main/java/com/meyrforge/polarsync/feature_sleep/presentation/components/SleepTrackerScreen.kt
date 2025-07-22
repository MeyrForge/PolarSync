package com.meyrforge.polarsync.feature_sleep.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.shared.InputFieldComponent
import com.meyrforge.polarsync.ui.shared.PolyTalkItem
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink

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
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Fecha", fontSize = 24.sp, color = PowderedPink)
            }
            HorizontalDivider(
                thickness = 2.dp,
                color = PowderedPink,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        item { HoursSliderComponent(10f) {} }
        item { WentToSleepClockComponent() }
        item { QuestionWithSegmentedButtonComponent("Tuviste pensamientos negativos?") }
        item { QuestionWithSegmentedButtonComponent("Estuviste ansioso antes de dormir?") }
        item { QuestionWithSegmentedButtonComponent("Dormiste de corrido?") }

    }
}