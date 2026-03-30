package com.example.to_do_app_jetpackcompose.presentation.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_do_app_jetpackcompose.R
import com.example.to_do_app_jetpackcompose.domain.model.Note


enum class DragValue {
    Settled,
    Revealed
}
@SuppressLint("RememberReturnType")
@Composable
fun NoteItem(
    note: Note,
    onStatusChange: () -> Unit,
    onItemDeleted: () -> Unit,
    onNoteClick: () -> Unit
) {

    val state = remember {
        AnchoredDraggableState(
            initialValue = DragValue.Settled,
            anchors = DraggableAnchors {
                DragValue.Settled at 0f
                DragValue.Revealed at -170f
            }
        )
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(76.dp,56.dp)
                .padding(end = 23.dp)
                .clickable { onItemDeleted() },
            tint = Color.Unspecified,
        )

        Row(
            modifier = Modifier
                .offset { IntOffset(state.offset.toInt(), 0) }
                .anchoredDraggable(
                    state = state,
                    orientation = Orientation.Horizontal
                )
                .offset{IntOffset(0,0)}
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 22.dp)
                .clickable { onNoteClick() }
                .background(Color(0xFFF3EFEE), RoundedCornerShape(12.dp)),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = note.isDone,
                onCheckedChange = { onStatusChange() }
            )

            Text(
                text = note.text,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = if (note.isDone) Color.Gray else Color.Black,
                    textDecoration = if (note.isDone) TextDecoration.LineThrough else TextDecoration.None
                )
            )
        }
    }
}

