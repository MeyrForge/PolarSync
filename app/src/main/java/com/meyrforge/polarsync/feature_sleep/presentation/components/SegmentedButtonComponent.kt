package com.meyrforge.polarsync.feature_sleep.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander

@Composable
fun SegmentedButtonComponent(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = true,
        thumbContent = if (checked) {
            {
                Text(
                    "SI",
                    fontSize = 10.sp
                )
            }
        } else {
            {
                Text(
                    "NO",
                    fontSize = 10.sp
                )
            }
        },
        colors = SwitchDefaults.colors(
            checkedTrackColor = PowderedPink,
            disabledCheckedTrackColor = Color.Gray,
            disabledUncheckedTrackColor = Color.Gray,
            uncheckedBorderColor = Color.Transparent,
            uncheckedThumbColor = SoftBlueLavander

        )
    )

}

@Composable
fun QuestionWithSegmentedButtonComponent(text:String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, fontSize = 18.sp, color = PowderedPink)
        SegmentedButtonComponent(true, {})
    }
}