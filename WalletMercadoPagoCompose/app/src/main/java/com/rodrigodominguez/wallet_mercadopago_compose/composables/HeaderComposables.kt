package com.rodrigodominguez.wallet_mercadopago_compose.composables

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.KeyboardArrowUp, tint = Color.White
        )
    }

}

@Composable
fun GetCardsList() {
    Row(
        Modifier.fillMaxWidth().height(84.dp).padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = Color.Black,
            modifier = Modifier.height(56.dp).width(280.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            ) {
                Modifier.padding(start = 16.dp, end = 16.dp)
                Image(
                    vectorResource(R.drawable.visa), contentScale = ContentScale.Crop
                )
                Image(
                    vectorResource(R.drawable.ic_iso_mp), contentScale = ContentScale.Crop
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
        verticalAlignment = Alignment.CenterVertically
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
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Outlined.ThumbUp
            )
            Text(
                text = "Pedi hoy tu prestamo de hasta $ 14.467",
                modifier = Modifier.width(210.dp).padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                color = Color.White,
                fontSize = 14.sp
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
        verticalAlignment = Alignment.CenterVertically
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
            verticalAlignment = Alignment.CenterVertically,
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
