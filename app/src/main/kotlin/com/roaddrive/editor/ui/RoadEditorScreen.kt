package com.roaddrive.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roaddrive.editor.ui.components.EditorCanvas
import com.roaddrive.editor.ui.components.ToolPanel

@Composable
fun RoadEditorScreen() {
    var selectedColor by remember { mutableStateOf(Color.Black) }
    var selectedTool by remember { mutableStateOf(EditorTool.PEN) }
    var brushSize by remember { mutableStateOf(5f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        TopAppBar(
            title = { Text("RoadDrive Editor") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )

        // Main content
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            // Left toolbar
            ToolPanel(
                selectedTool = selectedTool,
                onToolSelected = { selectedTool = it },
                selectedColor = selectedColor,
                onColorSelected = { selectedColor = it },
                brushSize = brushSize,
                onBrushSizeChanged = { brushSize = it }
            )

            // Canvas area
            EditorCanvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                selectedTool = selectedTool,
                selectedColor = selectedColor,
                brushSize = brushSize
            )
        }

        // Bottom action bar
        BottomAppBar(
            modifier = Modifier.height(56.dp),
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = { /* Clear canvas */ }) {
                    Icon(Icons.Default.Delete, contentDescription = "Clear")
                }
                IconButton(onClick = { /* Undo */ }) {
                    Icon(Icons.Default.Undo, contentDescription = "Undo")
                }
                IconButton(onClick = { /* Redo */ }) {
                    Icon(Icons.Default.Redo, contentDescription = "Redo")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* Save */ }) {
                    Icon(Icons.Default.Save, contentDescription = "Save")
                }
                IconButton(onClick = { /* Export */ }) {
                    Icon(Icons.Default.FileDownload, contentDescription = "Export")
                }
            }
        }
    }
}

enum class EditorTool {
    PEN, ERASER, LINE, CIRCLE, RECTANGLE, FILL
}