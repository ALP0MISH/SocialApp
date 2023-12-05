package com.example.socialapp.presentation.screens.onboarding.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.socialapp.R

sealed class OnBoardingPageItem(
    @StringRes open val buttonTextId: Int,
    open val isLastPage: Boolean = false

) {

    data class Welcome(
        @DrawableRes val imageId: Int,
        @StringRes val titleId: Int,
        @StringRes override val buttonTextId: Int,
        @DrawableRes val background: Int,
    ) : OnBoardingPageItem(buttonTextId, false)

    data class OnBoarding(
        @DrawableRes val imageId: Int,
        @StringRes val titleId: Int,
        @StringRes override val buttonTextId: Int,
        @StringRes val descriptionId: Int,
        override val isLastPage: Boolean = false
    ) : OnBoardingPageItem(buttonTextId, isLastPage)

    companion object {
        fun onboardingItems() = listOf(
            Welcome(
                titleId = R.string.welcome,
                imageId = R.drawable.welcome_onbording_image,
                background = R.drawable.welcome_onbording_background,
                buttonTextId = R.string.letsgo

            ),
            OnBoarding(
                imageId = R.drawable.first_onboarding_image,
                titleId = R.string.first_onboarding_tilte,
                descriptionId = R.string.first_onboarding_description,
                buttonTextId = R.string.Whatts_next

            ),
            OnBoarding(
                imageId = R.drawable.second_onboarding_image,
                titleId = R.string.second_onboarding_tilte,
                descriptionId = R.string.first_onboarding_description,
                buttonTextId = R.string.got_it
            ),
            OnBoarding(
                imageId = R.drawable.third_onboarding_image,
                titleId = R.string.third_onboarding_tilte,
                descriptionId = R.string.first_onboarding_description,
                isLastPage = true,
                buttonTextId = R.string.get_started
            )
        )
    }
}