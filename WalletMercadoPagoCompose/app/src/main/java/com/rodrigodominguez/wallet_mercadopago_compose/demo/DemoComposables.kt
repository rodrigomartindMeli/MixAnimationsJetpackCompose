package com.rodrigodominguez.wallet_mercadopago_compose.demo

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Outlined.Notifications, tint = Color.Blue
            )
            GetTextDemo(Color.Red)
        }
        Row (verticalAlignment = Alignment.CenterVertically){
            GetTextDemo(Color.Blue)
            Icon(
                Icons.Outlined.Notifications, tint = Color.Blue
            )
            GetTextDemo(Color.Green)
        }
    }
}

@Composable
fun GetTextDemo(color: Color) {
    Text(
        text = "Hola mundo",
        color = Color.White,
        modifier = Modifier.height(50.dp).background(color)
    )
}


