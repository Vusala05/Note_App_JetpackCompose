package com.example.to_do_app_jetpackcompose.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_do_app_jetpackcompose.R
import com.example.to_do_app_jetpackcompose.core.common.BaseTheme
import com.example.to_do_app_jetpackcompose.core.common.NoteFilter

@Composable
fun HomeScreenTopSection(
    selectedFilter: NoteFilter,
    onFilterSelected: (NoteFilter) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp, start = 22.dp, end = 22.dp),
    ) {
        Text(text = stringResource(R.string.today), style = BaseTheme.textStyle.tB36)
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(23.dp)
        ) {
            NoteFilter.entries.forEach { filter ->
                FilterChip(
                    text = filter.name,
                    isSelected = selectedFilter == filter,
                    onClick = { onFilterSelected(filter) }
                )
            }
        }
    }
}
