package com.example.pizzatime.Components

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.RoundingMode
import kotlin.math.PI
import kotlin.math.pow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextStack() {
    Surface(
        color = Color.LightGray,
//        modifier = Modifier.padding(16.dp)
    ) {
        var pizzaInput by remember {
            mutableStateOf(
                TextFieldValue("123")
            )
        }
        var pizzaArea by remember {
            mutableStateOf(
                (pizzaInput.text.toDouble()*0.5.pow(2) * PI)
                    .toBigDecimal()
                    .setScale(2, RoundingMode.HALF_UP)
                    .toDouble()
            )
        }

        val textRowModifier = Modifier
            .width(IntrinsicSize.Min)

        val superscript = SpanStyle(
            baselineShift = BaselineShift.Superscript,
            fontSize = 12.sp
        )
        val subscript = SpanStyle(
            baselineShift = BaselineShift.Subscript,
            fontSize = 14.sp
        )

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Row {
                Text(text = "Pizza Diameter (Inches)")
            }
            Row {
                BasicTextField(
                    modifier = textRowModifier,
                    value = pizzaInput,
                    onValueChange = {
                        pizzaInput = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)

                )
            }
            Row {
                Text(
                    text = buildAnnotatedString {
                        append("Pizza Area (Inches")
                        withStyle(superscript){
                            append("2")
                        }
                        append(")")
                    }
                )
            }
            Row {
                Text(
                    modifier = textRowModifier,
                    text = pizzaArea.toString()
                )
            }
        }
    }
}

@Preview
@Composable
fun TestColumn(){
    TextStack()
}