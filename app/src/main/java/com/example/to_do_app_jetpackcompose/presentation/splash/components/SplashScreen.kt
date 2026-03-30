package com.example.to_do_app_jetpackcompose.presentation.splash.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_do_app_jetpackcompose.R
import com.example.to_do_app_jetpackcompose.core.common.BaseTheme

@Composable
fun SplashScreen(
    onContinueClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box {

            Image(
                painter = painterResource(id = R.drawable.splash_screen ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Column {
                Text(
                    text = stringResource(R.string.splash_text),
                    style = BaseTheme.textStyle.t36,
                    modifier = Modifier.padding(top = 256.dp, end = 16.dp, start = 22.dp),
                    lineHeight = 40.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.frame),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 38.dp, top = 150.dp)
                        .size(BaseTheme.dimens.frame_width,BaseTheme.dimens.frame_height)

                )

                Button(
                    onClick = onContinueClick,
                    modifier = Modifier
                        .padding(start = 21.dp, end = 21.dp, top = 40.dp)
                        .fillMaxWidth()
                        .height(BaseTheme.dimens.dp16),
                    shape = RoundedCornerShape(BaseTheme.dimens.dp4),
                    colors = ButtonColors(colorResource(R.color.dark_charcoal),Color.White,colorResource(R.color.dark_charcoal) ,Color.White),

                    ) {
                    Text(
                        text = stringResource(R.string.Continue),
                        style = BaseTheme.textStyle.t18
                    )
                }
            }
        }
    }
}