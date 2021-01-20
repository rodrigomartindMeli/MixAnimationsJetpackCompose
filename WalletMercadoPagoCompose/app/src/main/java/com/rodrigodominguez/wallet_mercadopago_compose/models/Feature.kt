package com.rodrigodominguez.wallet_mercadopago_compose.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import java.io.Serializable

data class Feature(val name: String, @DrawableRes val image: Int, val color: Color? = Color.Black) :
    Serializable