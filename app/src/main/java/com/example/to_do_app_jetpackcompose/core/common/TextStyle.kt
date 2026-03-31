package com.example.to_do_app_jetpackcompose.core.common

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

object TextStyle {

    val t18 = TextStyle(
        fontSize = BaseTheme.dimens.sp02,
        fontWeight = FontWeight.W500,
    )
    val t36 = TextStyle(
        fontSize = BaseTheme.dimens.sp06,
        fontWeight = FontWeight.W600,
        color = Black
    )


    val tB36 = TextStyle(
        fontSize = BaseTheme.dimens.sp06,
        fontWeight = FontWeight.W700,
        color = Black
    )
    val tB12 = TextStyle(
        fontSize = BaseTheme.dimens.sp02,
        fontWeight = FontWeight.W700,
        color = Black
    )
    val t12 = TextStyle(
        fontSize = BaseTheme.dimens.sp02,
        fontWeight = FontWeight.W600,
        color = Color.LightGray
    )

    /*val t17 = TextStyle(
        fontSize = BaseTheme.dimens.sp02,
        fontWeight = FontWeight.W500,
        color = Black
    )*/



}