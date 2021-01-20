package com.rodrigodominguez.wallet_mercadopago_compose.composables

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.rodrigodominguez.wallet_mercadopago_compose.ui.DemoRecyclerViewActivity

@Composable
fun CreateToolbar(context: Context) {
    TopAppBar(
        title = { GetTitleToolbar() },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            GetIconAndActionMenu(context)
        },
        actions = {
            GetIconAndActionOptions(context)
        }
    )
}

@Composable
fun GetIconAndActionOptions(context: Context) {
    IconButton(onClick = {
        Toast.makeText(
            context,
            "Open Notifications Activity",
            Toast.LENGTH_SHORT
        ).show()
        context.startActivity(Intent(context, DemoRecyclerViewActivity::class.java))
    }) {
        Icon(Icons.Outlined.Notifications, tint = Color.White)
    }
}

@Composable
fun GetIconAndActionMenu(context: Context) {
    IconButton(onClick = {
        Toast.makeText(
            context,
            "Open Drawer",
            Toast.LENGTH_SHORT
        ).show()
    }) {
        Icon(Icons.Filled.Menu, tint = Color.White)
    }
}

@Composable
fun GetTitleToolbar() {
    Column {
        Text(
            text = "Hola Rodrigo",
            fontSize = 12.sp,
            color = Color.White
        )
        Text(
            text = "Nivel 6 - Mercado Puntos >",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}
