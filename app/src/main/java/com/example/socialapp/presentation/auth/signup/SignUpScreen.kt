package com.example.socialapp.presentation.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.socialapp.presentation.theme.ExtraMediumSpacing
import com.example.socialapp.presentation.theme.LargeBlue
import com.example.socialapp.presentation.theme.LargeSpacing
import com.example.socialapp.presentation.theme.MediumSpacing
import com.example.socialapp.presentation.theme.SmallSpacing

@Composable
fun SignUpScreen(
    uiState: SignUpUiState,
    onEvent: (SignUpEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TabBar(title = stringResource(id = R.string.singup))
        }
    ) { innerPaddings ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddings)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(ExtraLargeSpacing)
            LoginTextField(
                onValueChange = { onEvent(SignUpEvent.OnNameChange(it)) },
                placeHolder = stringResource(id = R.string.name),
                text = uiState.name
            )
            SpacerHeight(ExtraMediumSpacing)
            LoginTextField(
                onValueChange = { onEvent(SignUpEvent.OnLastNameChange(it)) },
                placeHolder = stringResource(id = R.string.last_name),
                text = uiState.lastName
            )
            SpacerHeight(ExtraMediumSpacing)
            LoginTextField(
                onValueChange = { onEvent(SignUpEvent.OnEmailChange(it)) },
                placeHolder = stringResource(id = R.string.email),
                text = uiState.email
            )
            SpacerHeight(ExtraMediumSpacing)
            LoginTextField(
                onValueChange = { onEvent(SignUpEvent.OnPasswordChange(it)) },
                placeHolder = stringResource(id = R.string.password),
                text = uiState.password
            )
            SpacerHeight(ExtraMediumSpacing)
            Button(
                onClick = {
                    onEvent(SignUpEvent.OnSingUpCLick)
                },
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LargeBlue,
                    contentColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Text(
                    modifier = Modifier.padding(vertical = MediumSpacing),
                    text = stringResource(id = R.string.singup),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
            }
            SpacerHeight(LargeSpacing)
            Row {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                SpacerWidth(SmallSpacing)
                Text(
                    modifier = Modifier.clickable { onEvent(SignUpEvent.OnLoginClick) },
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.bodyMedium,
                    color = LargeBlue
                )
            }
        }
    }
}