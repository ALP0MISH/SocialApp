package com.example.socialapp.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.socialapp.R

enum class BottomTabs(
    @DrawableRes val icon: Int,
    val title: String,
    val route: String
) {
    Home(
        icon = R.drawable.main_icon,
        title = "Home",
        route = "home_screen"
    ),
    Search(
        icon = R.drawable.search_icon,
        title = "Search",
        route = "search_screen"
    ),
    AddPost(
        icon = R.drawable.plus_icon,
        title = "AddPost",
        route = "add_post_screen"
    ),
    NOTIFICATION(
        icon = R.drawable.notification,
        title = "Notification",
        route = "notification_screen"
    ),
    PROFILE(
        icon = R.drawable.profile_icon,
        title = "Profile",
        route = "profile_screen"
    ),
}


@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val tabs = BottomTabs.entries.toList()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        tabs.forEach { bottomTabs ->
            AppBottomNavigationItem(
                modifier = Modifier.weight(1f),
                selected = currentRoute == bottomTabs.route,
                onClick = {
                    navController.navigate(bottomTabs.route)
                }, icon = painterResource(id = bottomTabs.icon)
            )
        }
    }
}

private const val DEFAULT_ICON_SIZE = 56

@Composable
fun AppBottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = DEFAULT_ICON_SIZE.dp,
) {
    val scale = if (selected) 1.5f else 1.0f

    val color = if (selected) Color.Blue
    else Color.LightGray

    val animatedScale: Float by animateFloatAsState(
        targetValue = scale,
        animationSpec = TweenSpec(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ), label = ""
    )
    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = TweenSpec(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ), label = ""
    )

    IconButton(
        onClick = onClick,
        modifier = modifier.size(iconSize)
    ) {
        Icon(
            painter = icon,
            contentDescription = String(),
            tint = animatedColor,
            modifier = Modifier.scale(animatedScale)
        )
    }
}