package com.example.socialapp.presentation.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.socialapp.R
import com.example.socialapp.presentation.components.CircularImage
import com.example.socialapp.presentation.components.SpacerHeight
import com.example.socialapp.presentation.screens.common.ErrorScreen
import com.example.socialapp.presentation.screens.common.LoadingScreen
import com.example.socialapp.presentation.theme.DarkPlaceholder
import com.example.socialapp.presentation.theme.ExtraLargeSpacing
import com.example.socialapp.presentation.theme.LargeSpacing
import com.example.socialapp.presentation.theme.LightPlaceholder

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEvent: (ProfileEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is ProfileUiState.Initial -> {}
        is ProfileUiState.Loading -> LoadingScreen()
        is ProfileUiState.Error -> ErrorScreen(
            message = uiState.message,
            onClick = { }
        )

        is ProfileUiState.Content -> LoadedProfileScreen(
            uiState = uiState,
            onEvent = onEvent,
            modifier = modifier
        )
    }
}

@Composable
fun LoadedProfileScreen(
    uiState: ProfileUiState.Content,
    onEvent: (ProfileEvent) -> Unit,

    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .height(160.dp)
                    .background(
                        if (isSystemInDarkTheme()) DarkPlaceholder
                        else LightPlaceholder
                    ),
                model = uiState.user.profileBackgroundImage,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .padding(end = LargeSpacing)
                    .padding(top = ExtraLargeSpacing)
                    .align(Alignment.TopEnd)
                    .size(32.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background)
                    .clickable { onEvent(ProfileEvent.OnEditProfile) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
                    .padding(horizontal = ExtraLargeSpacing),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularImage(
                    path = uiState.user.avatar,
                    size = 150,
                    modifier = Modifier
                )
                SpacerHeight(LargeSpacing)
                Text(
                    text = "${uiState.user.name} ${uiState.user.lastName}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                SpacerHeight(2.dp)
                val bio = uiState.user.bio
                if (bio != null) Text(
                    text = bio,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray
                )
                UserFollowInfo(
                    followersCount = 123,
                    followingCount = 123,
                    onEditProfileClick = { onEvent(ProfileEvent.OnEditProfile) }
                )
            }
        }
    }
}

@Composable
fun UserFollowInfo(
    followersCount: Int,
    followingCount: Int,
    onEditProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = followersCount.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.followers),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray,
                fontWeight = FontWeight.Normal
            )
        }
        Column {
            Text(
                text = followingCount.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.following),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray,
                fontWeight = FontWeight.Normal
            )
        }
        OutlinedButton(
            onClick = onEditProfileClick,
            modifier = Modifier,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(
                width = 1.dp,
                color = Color.LightGray
            )
        ) {
            Text(
                text = stringResource(id = R.string.edit_profile),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(
            uiState = ProfileUiState.Initial,
            onEvent = {}
        )
    }
}
