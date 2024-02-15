package com.example.socialapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.socialapp.presentation.theme.Blue
import com.example.socialapp.presentation.theme.Dark_Black
import com.example.socialapp.presentation.theme.MediumSpacing

@Composable
fun EditTextField(
    value: String,
    hint: String,
    topText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true,
    fieldModifier: Modifier = Modifier,
) {
    val grey = Dark_Black.copy(alpha = 0.5f)
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = fieldModifier,
            text = topText.uppercase(),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Dark_Black
        )
        SpacerHeight(MediumSpacing)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            singleLine = isSingleLine,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledIndicatorColor = grey,
                unfocusedIndicatorColor = grey,
                focusedIndicatorColor = Blue
            ),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = grey
                )
            },
            trailingIcon = {
                if (value.isNotEmpty()) Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onValueChange(String()) },
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        )
    }
}