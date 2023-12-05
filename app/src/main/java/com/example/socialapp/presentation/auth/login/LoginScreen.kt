package com.example.socialapp.presentation.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.socialapp.R
import com.example.socialapp.presentation.components.LoginTextField
import com.example.socialapp.presentation.components.SpacerHeight
import com.example.socialapp.presentation.components.SpacerWidth
import com.example.socialapp.presentation.components.TabBar
import com.example.socialapp.presentation.theme.ExtraLargeSpacing
import com.example.socialapp.presentation.theme.LargeBlue
import com.example.socialapp.presentation.theme.LargeSpacing
import com.example.socialapp.presentation.theme.SmallSpacing

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TabBar(title = stringResource(id = R.string.login))
        }

    ) { innerPaddings ->
        if (uiState.isAuthentication) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        Column(
            modifier = Modifier.padding(innerPaddings),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(ExtraLargeSpacing)
            LoginTextField(
                text = uiState.email,
                placeHolder = stringResource(id = R.string.login),
                onValueChange = { value ->
                    onEvent(LoginEvent.OnEmailChange(value))
                }
            )
            SpacerHeight(LargeSpacing)
            LoginTextField(
                text = uiState.password,
                placeHolder = stringResource(id = R.string.password),
                onValueChange = { value ->
                    onEvent(LoginEvent.OnPasswordChange(value))
                },
                isPassword = true
            )
            SpacerHeight(ExtraLargeSpacing)
            Button(
                onClick = { onEvent(LoginEvent.OnLoginClick) },
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    LargeBlue,
                    contentColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Text(
                    modifier = Modifier.padding(vertical = SmallSpacing),
                    text = stringResource(id = R.string.singup),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            SpacerHeight(size = ExtraLargeSpacing)
            Row {
                Text(
                    text = stringResource(id = R.string.dont_have_anaccount),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                SpacerWidth(SmallSpacing)
                Text(
                    modifier = Modifier.clickable { onEvent(LoginEvent.OnSingUpCLick) },
                    text = stringResource(id = R.string.singup),
                    style = MaterialTheme.typography.bodyMedium,
                    color = LargeBlue
                )
            }
        }
    }
}