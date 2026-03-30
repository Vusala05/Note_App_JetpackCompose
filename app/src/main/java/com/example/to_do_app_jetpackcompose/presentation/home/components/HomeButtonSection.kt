package com.example.to_do_app_jetpackcompose.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_do_app_jetpackcompose.R
import com.example.to_do_app_jetpackcompose.core.common.BaseTheme
import com.example.to_do_app_jetpackcompose.core.common.Dimens
import com.example.to_do_app_jetpackcompose.domain.model.Note

@Composable
fun HomeBottomSection(
    selectedNote: Note?,
    onAddClick: (String) -> Unit,
    onEditClick: (Note, String) -> Unit
) {
    var tfValue by remember(selectedNote?.id) {
        mutableStateOf(selectedNote?.text ?: "")
    }

    Row(
        modifier = Modifier
            .imePadding()
            .fillMaxWidth()
            .padding(bottom = 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = tfValue,
            onValueChange = { tfValue = it },
            modifier = Modifier
                .padding(start = 21.dp, top = 14.dp, bottom = 14.dp)
                .size(BaseTheme.dimens.add_task_width, BaseTheme.dimens.dp16),
            shape = RoundedCornerShape(BaseTheme.dimens.dp3),
            placeholder = {
                Text(text = stringResource(R.string.write_task),
                    style = BaseTheme.textStyle.t18)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = colorResource(R.color.light_gray),
                unfocusedContainerColor = colorResource(R.color.light_gray),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.Black
            )
        )

        Button(
            onClick = {
                if (tfValue.trim().isNotEmpty()) {
                    if (selectedNote == null) {
                        onAddClick(tfValue)
                    } else {
                        onEditClick(selectedNote, tfValue)
                    }
                    tfValue = ""
                }
            },
            modifier = Modifier
                .padding(start = BaseTheme.dimens.dp3, end = 22.dp, top = 14.dp, bottom = 14.dp)
                .size(BaseTheme.dimens.add_btn_width, BaseTheme.dimens.dp16),
            shape = RoundedCornerShape(BaseTheme.dimens.dp3),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.dark_charcoal),
                contentColor = Color.White
            )
        ) {
            Text(
                text = if (selectedNote == null) stringResource(R.string.add) else stringResource(R.string.edit),
                style = BaseTheme.textStyle.t18,
                color = Color.White
            )
        }
    }
}

