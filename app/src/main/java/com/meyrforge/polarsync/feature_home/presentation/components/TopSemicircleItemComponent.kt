package com.meyrforge.polarsync.feature_home.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Preview(showBackground = true, backgroundColor = 0xFF27252C)
@Composable
fun TopSemicircleItem() {
    Box(contentAlignment = Alignment.Center){
        Box{
            Box(modifier = Modifier.fillMaxWidth().height(80.dp).background(PowderedPink))
            Canvas(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                drawArc(
                    color = PowderedPink,
                    startAngle = 0f,
                    sweepAngle = 180f,
                    useCenter = false,
                    size = size,
                    topLeft = Offset(x = 0f, y = 0f)
                )
            }
        }

        Text(
            "Bienvenido Freyr",
            modifier = Modifier.padding(0.dp),
            color = DeepPurple,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}