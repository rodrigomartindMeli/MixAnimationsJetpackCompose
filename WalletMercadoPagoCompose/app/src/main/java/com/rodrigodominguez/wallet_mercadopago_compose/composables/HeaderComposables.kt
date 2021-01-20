package com.rodrigodominguez.wallet_mercadopago_compose.composables

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.rodrigodominguez.wallet_mercadopago_compose.R
import com.rodrigodominguez.wallet_mercadopago_compose.ui.MP_primary_50
import com.rodrigodominguez.wallet_mercadopago_compose.ui.MP_secundary
import com.rodrigodominguez.wallet_mercadopago_compose.ui.WalletMercadoPagoComposeTheme

@Composable
fun CreateHeaderWallet() {
    Surface(
        color = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(bottomRight = 16.dp, bottomLeft = 16.dp)
    ) {
        Column(Modifier.wrapContentSize().padding(bottom = 16.dp)) {
            Divider(Modifier.height(8.dp), color = MaterialTheme.colors.primary)
            GetRowAccount()
            Divider(
                Modifier.height(0.5.dp).padding(start = 16.dp, end = 16.dp),
                color = Color.LightGray
            )
            GetRowBalance()
            Divider(
                Modifier.height(0.5.dp).padding(start = 16.dp, end = 16.dp),
                color = Color.LightGray
            )
            GetRowLoanOffer()
            Divider(
                Modifier.height(0.5.dp).padding(start = 16.dp, end = 16.dp),
                color = Color.LightGray
            )
            GetCardsList()
            GetImageUp()
        }
    }
}

@Composable
fun GetImageUp() {
    Row(
        Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalGravity = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.KeyboardArrowUp, tint = Color.White
        )
    }

}

@Composable
fun GetCardsList() {
    val imageVisa = vectorResource(R.drawable.visa)
    val imageIsoMP = vectorResource(R.drawable.ic_iso_mp)
    Row(
        Modifier.fillMaxWidth().height(84.dp).padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = Color.Black,
            modifier = Modifier.height(56.dp).width(280.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalGravity = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            ) {
                Modifier.padding(start = 16.dp, end = 16.dp)
                Image(
                    asset = imageVisa, contentScale = ContentScale.Crop
                )
                Image(
                    asset = imageIsoMP, contentScale = ContentScale.Crop
                )
            }
        }
        Icon(
            Icons.Default.KeyboardArrowRight, tint = Color.White
        )
    }
}

@Composable
fun GetRowAccount() {
    Row(
        Modifier.fillMaxWidth().height(84.dp).padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Dinero invertido disponible",
                fontSize = 14.sp,
                color = Color.White,
            )
            Text(
                text = "$ 54,546",
                fontSize = 24.sp,
                color = Color.White,
            )
        }
        Icon(
            Icons.Default.KeyboardArrowRight, tint = Color.White
        )
    }
}

@Composable
fun GetRowLoanOffer() {
    Row(
        Modifier.fillMaxWidth().height(64.dp).padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        Row(
            verticalGravity = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.background(MP_primary_50, RoundedCornerShape(16.dp))
                    .height(36.dp)
                    .width(36.dp),
                asset = Icons.Outlined.ThumbUp, tint = Color.White
            )
            Text(
                modifier = Modifier.width(210.dp).padding(start = 16.dp)
                    .gravity(Alignment.CenterVertically),
                text = "Pedi hoy tu prestamo de hasta $ 14.467",
                fontSize = 14.sp,
                color = Color.White,
            )
        }
        Icon(
            Icons.Default.KeyboardArrowRight, tint = Color.White
        )
    }
}

@Composable
fun GetRowBalance() {
    Row(
        Modifier.fillMaxWidth().height(64.dp).padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(3f),
            text = "$ 12.324 generados este año",
            fontSize = 16.sp,
            color = Color.White,
        )
        Row(
            modifier = Modifier.weight(0.7f)
                .background(color = MP_secundary, RoundedCornerShape(12.dp)),
            verticalGravity = Alignment.CenterVertically,
            horizontalArrangement = AbsoluteArrangement.Center

        ) {
            Icon(
                Icons.Sharp.KeyboardArrowUp, tint = Color.White
            )
            Text(
                text = "19%",
                fontSize = 14.sp,
                color = Color.White,
            )
        }
        Icon(
            Icons.Default.KeyboardArrowRight, tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}
