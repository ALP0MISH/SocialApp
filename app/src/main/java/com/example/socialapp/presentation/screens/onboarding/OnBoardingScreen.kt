@file:Suppress("UNUSED_EXPRESSION")

package com.example.socialapp.presentation.screens.onboarding

import AnimateTypewriterText
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialapp.R
import com.example.socialapp.presentation.components.SpacerHeight
import com.example.socialapp.presentation.components.advancedShadow
import com.example.socialapp.presentation.screens.onboarding.models.OnBoardingPageItem
import com.example.socialapp.presentation.theme.INTER_FONT
import com.example.socialapp.presentation.theme.White
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navigateToLoginScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val onboardings = OnBoardingPageItem.onboardingItems()
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        val isNotWelcomeScreen = pagerState.currentPage != 0
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = if (isNotWelcomeScreen) R.drawable.onboarding_background_image
                else R.drawable.onboarding_background_image
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
    Column(
        modifier = Modifier
            .padding(bottom = 45.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = onboardings.size,
            state = pagerState
        ) { position ->
            when (val onboarding = onboardings[position]) {
                is OnBoardingPageItem.Welcome -> WelcomeOnboarding(
                    titleId = onboarding.titleId,
                    imageId = onboarding.imageId,
                    backgroundId = onboarding.background
                )

                is OnBoardingPageItem.OnBoarding -> {
                    OnboardingPage(page = onboarding)
                }
            }
        }
        val page = onboardings[pagerState.currentPage]
        if (page is OnBoardingPageItem.OnBoarding) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                text = stringResource(id = page.titleId),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )
            SpacerHeight(16.dp)
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                text = stringResource(id = page.descriptionId),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        OnBoardingAnimatedTextField(
            page = onboardings[pagerState.currentPage],
            onNextPage = { isLastPage ->
                if (isLastPage) navigateToLoginScreen()
                else scope.launch { pagerState.animateScrollToPage(pagerState.currentPage.inc()) }
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = onboardings.size,
            indicatorWidth = 30.dp,
            indicatorHeight = 4.dp,
            inactiveColor = Color.Gray,
            activeColor = Color.White,
            spacing = 8.dp
        )
    }
}

@Composable
fun OnBoardingAnimatedTextField(
    page: OnBoardingPageItem,
    onNextPage: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 36.dp)
            .fillMaxWidth()
            .advancedShadow(
                color = Color.White,
                alpha = 0.9f,
                shadowBlurRadius = 40.dp
            )
            .height(52.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { onNextPage(page.isLastPage) }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (page.isLastPage) Spacer(modifier = Modifier.weight(1f))
            AnimateTypewriterText(
                modifier = Modifier,
                baseText = String(),
                highlightText = "|",
                parts = listOf(stringResource(id = page.buttonTextId))
            )
            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(visible = !page.isLastPage) {
                IconButton(onClick = { onNextPage(page.isLastPage) }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
fun OnboardingPage(
    page: OnBoardingPageItem.OnBoarding,
    modifier: Modifier = Modifier
) {
    val isFirstPage = page.imageId == R.drawable.first_onboarding_image
    Column(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(389.dp)
            .padding(if (isFirstPage) 0.dp else 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = if (page.isLastPage) 16.dp else 0.dp),
            painter = painterResource(id = page.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun WelcomeOnboarding(
    @StringRes titleId: Int,
    @DrawableRes imageId: Int,
    @DrawableRes backgroundId: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(25.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = titleId),
                fontFamily = INTER_FONT,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = White
            )
            Spacer(modifier = Modifier.height(222.dp))
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun WelcomeOnboardingPreview() {
    MaterialTheme {
        WelcomeOnboarding(
            titleId = R.string.welcome,
            backgroundId = R.drawable.welcome_onbording_background,
            imageId = R.drawable.welcome_onbording_image
        )
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
//    MaterialTheme {
//        OnBoardingScreen()
//    }
}