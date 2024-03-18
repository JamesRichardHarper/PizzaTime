package com.example.pizzatime.Drawings

import android.graphics.Canvas
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

class Pizza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is an extension function of Activity that sets the @Composable function that's
        // passed to it as the root view of the activity. This is meant to replace the .xml file
        // that we would typically set using the setContent(R.id.xml_file) method. The setContent
        // block defines the activity's layout.
        setContent {
            DrawPizza()
        }
    }
}

@Composable
fun DrawPizza(){
    val crustColour = Color(0xFF8B4513)
    val cheeseColour = Color(0xFFDAA520)
    var pizzaSize by remember { mutableStateOf(Size.Zero) }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .onGloballyPositioned { layoutCoordinates ->
                layoutCoordinates.size.toSize()
            }

    ){
        drawCircle(
            color = crustColour
        )
        drawCircle(
            color = cheeseColour,
//            radius = LocalDensity.current.run {(0.5f*pizzaSize.height)}
        )
    }
}

@Preview
@Composable
fun PreviewPizza(){
    DrawPizza()
}