package com.example.socialapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.socialapp.R
import com.example.socialapp.presentation.models.User
import com.example.socialapp.presentation.theme.ExtraLargeSpacing
import com.example.socialapp.presentation.theme.LargeSpacing
import com.example.socialapp.presentation.theme.MediumSpacing


@Composable
fun OnBoardingSelection(
    users: List<User>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MediumSpacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.onboarding_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = stringResource(id = R.string.onboarding_description),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        SpacerHeight(LargeSpacing)
        LazyRow(
            contentPadding = PaddingValues(horizontal = MediumSpacing),
            horizontalArrangement = Arrangement.spacedBy(ExtraLargeSpacing)
        ) {
            items(
                items = users,
                key = { item -> item.objectId }
            ) { user ->
                UserOnBoardingItem(user = user)
            }
        }
        SpacerHeight(LargeSpacing)
    }
}

@Composable
fun UserOnBoardingItem(
    user: User,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(ExtraLargeSpacing),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularImage(
                path = user.avatar,
                size = 64
            )
            SpacerHeight(MediumSpacing)
            Text(
                text = user.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            SpacerHeight(MediumSpacing)
            OutlinedButton(
                onClick = { },
                modifier = Modifier,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.LightGray
                )
            ) {
                Text(
                    text = "Follow",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}