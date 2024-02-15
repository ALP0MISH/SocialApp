package com.example.socialapp.presentation.app

import android.app.Application
import com.example.socialapp.di.APPLICATION_ID
import com.example.socialapp.di.CLIENT_KEY
import com.example.socialapp.di.PARSE_BASE_URL
import com.parse.Parse
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SocialApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.enableLocalDatastore(this)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(PARSE_BASE_URL)
                .build()
        )
    }
}