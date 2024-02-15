package com.example.socialapp.presentation.screens.editProfile

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.socialapp.R
import com.example.socialapp.presentation.components.CircularImage
import com.example.socialapp.presentation.components.EditTextField
import com.example.socialapp.presentation.components.SpacerHeight
import com.example.socialapp.presentation.components.TabBar
import com.example.socialapp.presentation.extensions.getCapturedImage
import com.example.socialapp.presentation.screens.common.ErrorScreen
import com.example.socialapp.presentation.screens.common.LoadingScreen
import com.example.socialapp.presentation.theme.Blue
import com.example.socialapp.presentation.theme.ExtraLargeSpacing

const val IMAGE_PICKER = "image/*"
const val EDIT_PROFILE_ROUTE = "edit_profile_route"

@Composable
fun EditProfileScreen(
    uiState: EditProfileUiState,
    uploadProgress: AvatarUploadProgress?,
    onEvent: (EditProfileEvent) -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val progress by remember { mutableStateOf(uploadProgress?.progress) }
    var openAlertDialog by remember { mutableStateOf(false) }
    openAlertDialog = uploadProgress != null
    Scaffold(
        topBar = {
            TabBar(
                title = stringResource(id = R.string.edit_profile),
                aligment = Alignment.Center,
                startIcon = Icons.Default.ArrowBack,
                startIconClick = { navController.navigateUp() },
                endIcon = Icons.Default.Save,
                endIconClick = { onEvent(EditProfileEvent.OnSaveButtonClick) }
            )
        }
    ) { innerPadding ->
        if (openAlertDialog && progress != null) {
            UploadDialog(
                progress = progress!!,
                onDismissRequest = { openAlertDialog = false }
            )
        }
        when (uiState) {
            is EditProfileUiState.Initial -> {}
            is EditProfileUiState.Loading -> LoadingScreen()
            is EditProfileUiState.Error -> ErrorScreen(
                message = uiState.message,
                onClick = { }
            )

            is EditProfileUiState.Content -> LoadedEditProfileScreen(
                uiState = uiState,
                onEvent = onEvent,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun LoadedEditProfileScreen(
    uiState: EditProfileUiState.Content,
    onEvent: (EditProfileEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpacerHeight(size = 36.dp)
        UseAvatar(avatar = uiState.user.avatar,
            onAvatarChanged = { onEvent(EditProfileEvent.OnAvatarChanged(it)) }
        )
        SpacerHeight(size = 48.dp)
        EditTextField(value = uiState.email,
            hint = stringResource(id = R.string.email_hilt),
            topText = stringResource(id = R.string.your_email),
            onValueChange = { onEvent(EditProfileEvent.OnEmailChange(it)) }
        )
        SpacerHeight(size = ExtraLargeSpacing)
        EditTextField(value = uiState.name,
            hint = stringResource(id = R.string.name_hilt),
            topText = stringResource(id = R.string.your_name),
            onValueChange = { onEvent(EditProfileEvent.OnNameChange(it  )) }
        )
        SpacerHeight(size = ExtraLargeSpacing)
        EditTextField(value = uiState.lastName,
            hint = stringResource(id = R.string.last_name_hilt),
            topText = stringResource(id = R.string.your_lastname),
            onValueChange = { onEvent(EditProfileEvent.OnLastNameChange(it)) }
        )
        SpacerHeight(size = ExtraLargeSpacing)
        EditTextField(value = uiState.aboutMe,
            isSingleLine = false,
            hint = stringResource(id = R.string.about_me_hint),
            topText = stringResource(id = R.string.about_me),
            onValueChange = { onEvent(EditProfileEvent.OnAboutChange(it)) }
        )
    }
}


@Composable
fun UseAvatar(
    avatar: String?,
    onAvatarChanged: (Bitmap) -> Unit,
    modifier: Modifier = Modifier
) {
    var context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var imageUrl by remember { mutableStateOf<Uri?>(null) }
    var isAvatarPlaceholder by remember { mutableStateOf(false) }

    var galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri -> uri?.let { imageUrl = it } }
    )

    LaunchedEffect(key1 = imageUrl) {
        if (imageUrl != null) {
            bitmap = imageUrl.getCapturedImage(context)
            onAvatarChanged(bitmap!!)
        }
    }

    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
    ) {

        CircularImage(
            modifier = Modifier.clickable { isAvatarPlaceholder = !isAvatarPlaceholder },
            path = bitmap ?: avatar,
            size = 120
        )
        AnimatedVisibility(
            visible = isAvatarPlaceholder,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            if (isAvatarPlaceholder) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            galleryLauncher.launch(IMAGE_PICKER)
                            isAvatarPlaceholder = false
                        }
                        .background(Blue.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Outlined.PhotoCamera,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun UploadDialog(
    progress: Int,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "progress = $progress",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}