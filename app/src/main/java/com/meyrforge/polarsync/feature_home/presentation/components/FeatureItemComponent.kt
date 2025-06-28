package com.meyrforge.polarsync.feature_home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Mood
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.pink

@Composable
fun FeatureItemComponent(icon: ImageVector, title: String, color: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color.copy(alpha = 0.2f))
            //.border(2.dp, color, RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.height(50.dp)) {
            Icon(
                icon,
                contentDescription = title,
                tint = color,
                modifier = Modifier.size(60.dp)
            )
        }
        Box(modifier = Modifier.height(80.dp)) {
            Text(
                title,
                color = color,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.weight(5f)) {
            FeatureItemComponent(Icons.Outlined.Mood, "Estados de ánimo", pink)
        }
        Box(modifier = Modifier.weight(5f)) {
            FeatureItemComponent(Icons.Outlined.Medication, "Medicación", pink)
        }
    }
}