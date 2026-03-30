package com.example.to_do_app_jetpackcompose.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_do_app_jetpackcompose.R
import com.example.to_do_app_jetpackcompose.core.common.BaseTheme

@Composable
fun FilterChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(BaseTheme.dimens.dp2),
        color = if (isSelected) colorResource(R.color.cream) else colorResource(R.color.light_gray),
        modifier = Modifier.height(BaseTheme.dimens.option_height)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                text = text,
               style = if(isSelected) BaseTheme.textStyle.tB12 else BaseTheme.textStyle.t12
            )
        }
    }
}
