package com.roaddrive.editor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.roaddrive.editor.ui.EditorTool

@Composable
fun EditorCanvas(
    modifier: Modifier = Modifier,
    selectedTool: EditorTool,
    selectedColor: Color,
    brushSize: Float
) {
    var paths by remember { mutableStateOf(listOf<DrawPath>()) }
    var currentPath by remember { mutableStateOf(listOf<Pair<Float, Float>>()) }

    Box(
        modifier = modifier
            .background(Color(0xFFF5F5F5))
            .pointerInput(selectedTool, selectedColor, brushSize) {
                detectDragGestures(
                    onDragStart = { offset ->
                        currentPath = listOf(offset.x to offset.y)
                    },
                    onDrag = { change, _ ->
                        currentPath = currentPath + (change.position.x to change.position.y)
                    },
                    onDragEnd = {
                        if (currentPath.isNotEmpty()) {
                            paths = paths + DrawPath(
                                points = currentPath,
                                color = selectedColor,
                                size = brushSize,
                                tool = selectedTool
                            )
                            currentPath = emptyList()
                        }
                    }
                )
            }
    )
}

data class DrawPath(
    val points: List<Pair<Float, Float>>,
    val color: Color,
    val size: Float,
    val tool: EditorTool
)