package com.example.socialapp.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.socialapp.R
import com.example.socialapp.presentation.theme.BackgroundSecondaryDark
import com.example.socialapp.presentation.theme.ExtraLargeSpacing
import com.example.socialapp.presentation.theme.Light_Gray

@Composable
fun LoginTextField(
    onValueChange: (String) -> Unit,
    placeHolder: String,
    isPassword: Boolean = false,
    text: String,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            focusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = if (isSystemInDarkTheme()) BackgroundSecondaryDark else BackgroundSecondaryDark,

            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            disabledTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,

            focusedPlaceholderColor = Color.LightGray,
            disabledLabelColor = Color.LightGray,
            unfocusedLabelColor = Color.LightGray
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = if (isPassword) KeyboardType.Password
            else KeyboardType.Text
        ),
        visualTransformation = if (isPasswordVisible) PasswordVisualTransformation()
        else VisualTransformation.None,
        placeholder = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.bodyMedium,
                color = Light_Gray
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        trailingIcon = {
            if (isPassword) {
                val iconId = if (isPasswordVisible) R.drawable.show_eye_icon_filled
                else R.drawable.hide_eye_icon_filled
                IconButton(
                    onClick = { isPasswordVisible = !isPasswordVisible }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = iconId),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                }
            }
        },
        shape = MaterialTheme.shapes.medium
    )
}