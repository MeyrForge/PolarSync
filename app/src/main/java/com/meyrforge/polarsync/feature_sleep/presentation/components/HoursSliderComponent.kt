package com.meyrforge.polarsync.feature_sleep.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander

@Preview
@Composable
fun HoursSliderPreview(){
    HoursSliderComponent(10f) { }
}



@Composable
fun HoursSliderComponent(sliderPosition: Float, onSliderChange: (Float) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().height(116.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), contentAlignment = Alignment.CenterStart) {
            Text("Horas de sueño", fontSize = 18.sp, color = PowderedPink)
        }
//        HorizontalDivider(thickness = 2.dp, color = PowderedPink, modifier = Modifier.padding(vertical = 8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("0", fontSize = 24.sp, color = PowderedPink)
            Text(sliderPosition.toInt().toString(), fontSize = 28.sp, color = SoftBlueLavander)
            Text("24", fontSize = 24.sp, color = PowderedPink)
        }
        Slider(
            sliderPosition, {}, steps = 24, valueRange = 0f..24f, colors = SliderDefaults.colors(
                thumbColor = SoftBlueLavander,
                activeTrackColor = PowderedPink,
                activeTickColor = DeepPurple,
                inactiveTickColor = PowderedPink,
                disabledActiveTrackColor = SoftBlueLavander,
                disabledThumbColor = SoftBlueLavander,
            ),
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}