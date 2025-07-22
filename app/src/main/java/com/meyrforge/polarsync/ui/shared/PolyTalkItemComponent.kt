package com.meyrforge.polarsync.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meyrforge.polarsync.R
import com.meyrforge.polarsync.ui.theme.LightWarmGray
import com.meyrforge.polarsync.ui.theme.PowderedPink

@Preview(showBackground = true, backgroundColor = 0xFF27252C)
@Composable
fun PolyTalkItem() {
    Box(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(PowderedPink.copy(alpha = 0.4f)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .shadow(10.dp, CircleShape)
                .background(LightWarmGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.poly_greeting),
                contentDescription = "Poly"
            )
        }
    }
}