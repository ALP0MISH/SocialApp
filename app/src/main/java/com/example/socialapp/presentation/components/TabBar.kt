package com.example.socialapp.presentation.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.socialapp.presentation.screens.editProfile.EditProfileEvent
import com.example.socialapp.presentation.screens.editProfile.EditProfileUiState
import com.example.socialapp.presentation.screens.editProfile.IMAGE_PICKER
import com.example.socialapp.presentation.theme.Blue
import com.example.socialapp.presentation.theme.INTER_FONT
import com.example.socialapp.presentation.theme.LargeSpacing
import com.example.socialapp.presentation.theme.MediumSpacing


@Composable
fun TabBar(
    title: String,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    startIconClick: () -> Unit = {},
    endIconClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    aligment: Alignment = Alignment.CenterStart
) {
    Surface(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth(),
        elevation = 4.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier
                .padding(LargeSpacing)
                .fillMaxWidth(),
        ) {
            if (startIcon != null) {
                TabBarIcon(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = MediumSpacing),
                    icon = startIcon,
                    onClick = startIconClick
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = INTER_FONT,
                fontWeight = FontWeight.Bold
            )
            if (endIcon != null) {
                TabBarIcon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = MediumSpacing),
                    icon = endIcon,
                    onClick = endIconClick
                )
            }
        }
    }
}

@Composable
fun TabBarIcon(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.background)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}
