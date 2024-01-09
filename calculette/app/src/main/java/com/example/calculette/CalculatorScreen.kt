package com.example.calculette

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)){
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)) {
                Text(
                    text = "5+8=",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )
                )
                Text(
                    text = "13",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 60.sp,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .padding(8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "CA",
                    isHighLight = true
                ) {}
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "/",
                    isHighLight = true
                ) {}
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "X",
                    isHighLight = true
                ) {}
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.ArrowBack,
                    isHighLight = true
                ) {}
            }
        }
    }
}

@Composable
fun ActionCalculator (
    modifier: Modifier = Modifier,
    character: String? = null,
    icon: ImageVector? = null,
    isHighLight: Boolean = false,
    onActionCalculatorClick: () -> Unit
) {
    Box(modifier = Modifier
        .size(60.dp)
        .clip(RoundedCornerShape(50))
        .clickable { onActionCalculatorClick() }
    ) {
        if(icon != null) {
            Icon(imageVector = icon, contentDescription = "Symbole à afficher",
                tint = Color.Red)
        } else {
            Text(text = character!!,
                style = TextStyle(
                    fontSize = 30.sp,
                    color = if(isHighLight) Color.Green else Color.Black
                ),
                modifier = Modifier.align(Alignment.Center)

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview(){
    CalculatorScreen()
}
