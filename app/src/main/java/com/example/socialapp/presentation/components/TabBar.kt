package com.example.socialapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.socialapp.presentation.theme.LargeSpacing

@Composable
fun TabBar(
    title: String,
    modifier: Modifier = Modifier,
    aligment: Alignment = Alignment.CenterStart
) {
    Surface(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth(),
        elevation =  4.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier
                .padding(LargeSpacing)
                .fillMaxWidth(),

            ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}