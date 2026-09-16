package com.roaddrive.editor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roaddrive.editor.ui.EditorTool

@Composable
fun ToolPanel(
    selectedTool: EditorTool,
    onToolSelected: (EditorTool) -> Unit,
    selectedColor: Color,
    onColorSelected: (Color) -> Unit,
    brushSize: Float,
    onBrushSizeChanged: (Float) -> Unit
) {
    Column(
        modifier = Modifier
            .width(80.dp)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Tools", style = MaterialTheme.typography.labelSmall)

        // Tool buttons
        ToolButton(
            icon = Icons.Default.Create,
            label = "Pen",
            isSelected = selectedTool == EditorTool.PEN,
            onClick = { onToolSelected(EditorTool.PEN) }
        )
        ToolButton(
            icon = Icons.Default.Clear,
            label = "Eraser",
            isSelected = selectedTool == EditorTool.ERASER,
            onClick = { onToolSelected(EditorTool.ERASER) }
        )
        ToolButton(
            icon = Icons.Default.LineWeight,
            label = "Line",
            isSelected = selectedTool == EditorTool.LINE,
            onClick = { onToolSelected(EditorTool.LINE) }
        )
        ToolButton(
            icon = Icons.Default.RadioButtonChecked,
            label = "Circle",
            isSelected = selectedTool == EditorTool.CIRCLE,
            onClick = { onToolSelected(EditorTool.CIRCLE) }
        )
        ToolButton(
            icon = Icons.Default.CropSquare,
            label = "Square",
            isSelected = selectedTool == EditorTool.RECTANGLE,
            onClick = { onToolSelected(EditorTool.RECTANGLE) }
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Size", style = MaterialTheme.typography.labelSmall)
        Slider(
            value = brushSize,
            onValueChange = onBrushSizeChanged,
            valueRange = 1f..50f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ToolButton(
    icon: androidx.compose.material.icons.Icons.Outlined,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
            )
    ) {
        Icon(icon, contentDescription = label)
    }
}