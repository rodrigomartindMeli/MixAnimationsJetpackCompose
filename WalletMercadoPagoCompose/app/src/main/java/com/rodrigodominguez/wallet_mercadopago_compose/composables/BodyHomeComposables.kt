package com.rodrigodominguez.wallet_mercadopago_compose.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rodrigodominguez.wallet_mercadopago_compose.R
import com.rodrigodominguez.wallet_mercadopago_compose.models.Feature
import com.rodrigodominguez.wallet_mercadopago_compose.ui.*

@Composable
fun CreateBodyHome() {
    GetPrincipalFeatures()
    GetSecundaryFeatures()
    GetDiscounts()
    GetQRLocations()
    GetBannerOfferFeatures()
    GetMovements()
    GetLevelInformation()
    GetInformationApp()
}

@Composable
fun GetPrincipalFeatures() {
    Row(
        Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (feature in getPrimaryFeatures()) {
            GetItemFeature(
                feature,
                Color.White,
                MaterialTheme.colors.onSurface,
                GetModifierPrimaryFeatures()
            )
        }
    }
}

fun getPrimaryFeatures(): List<Feature> {
    return listOf(
        Feature("Codigo QR", R.drawable.ic_qr_code_scanner_24px),
        Feature("Ingresar dinero", R.drawable.ic_arrow_upward_24px),
        Feature("Transferi dinero", R.drawable.ic_arrow_forward_24px),
        Feature("Retirar dinero", R.drawable.ic_arrow_downward_24px)
    )
}

fun getSecondaryFeatures(): List<Feature> {
    return listOf(
        Feature("Recargar Celular", R.drawable.ic_phone_android_24px, color = MP_Cyan),
        Feature("Pagar con NFC", R.drawable.ic_nfc_24px, color = MP_Indogo),
        Feature("Pagar con QR", R.drawable.ic_qr_code_2_24px, color = MP_Indogo),
        Feature("Cobrar Point", R.drawable.ic_point_of_sale_24px, MP_Pink),
        Feature("Cobrar Link", R.drawable.ic_link_24px, MP_Pink),
        Feature("Mercado puntos", R.drawable.ic_loyalty_24px, MP_Cyan),
        Feature("Cargar Sube", R.drawable.ic_directions_bus_24px, MP_primary),
        Feature("Ver mas", R.drawable.ic_add_24px, Color.DarkGray)
    )
}

@Composable
fun GetItemFeature(feature: Feature, tintColor: Color, textColor: Color, modifier: Modifier) {
    val imageQR = vectorResource(feature.image)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            vectorResource(feature.image),
            tint = tintColor,
            modifier = modifier
        )
        Text(feature.name, color = textColor, textAlign = TextAlign.Center)
    }
}

@Composable
fun GetSecundaryFeatures() {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
            Alignment.Center
        ) {
            Column {
                Row(
                    Modifier.fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (feature in getSecondaryFeatures().subList(0, 4)) {
                        GetItemFeature(
                            feature,
                            feature.color!!,
                            MaterialTheme.colors.onSurface,
                            GetModifierSecondaryFeatures()
                        )
                    }
                }

                Row(
                    Modifier.fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (feature in getSecondaryFeatures().subList(4, 8)) {
                        GetItemFeature(
                            feature,
                            feature.color!!,
                            MaterialTheme.colors.onSurface,
                            GetModifierSecondaryFeatures()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GetModifierSecondaryFeatures(): Modifier {
    return Modifier.height(56.dp).width(56.dp).padding(2.dp)
        .border(
            border = BorderStroke(width = 1.dp, color = MP_Gray_A3),
            shape = RoundedCornerShape(24.dp)
        )

}

@Composable
fun GetModifierPrimaryFeatures(): Modifier {
    return Modifier.height(56.dp).width(56.dp).padding(2.dp)
        .background(shape = CircleShape, color = MaterialTheme.colors.primary)
}

@Composable
fun GetDiscounts() {

}

@Composable
fun GetQRLocations() {

}

@Composable
fun GetBannerOfferFeatures() {

}

@Composable
fun GetMovements() {

}

@Composable
fun GetLevelInformation() {
}

@Composable
fun GetInformationApp() {
}


