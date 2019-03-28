package com.gpetuhov.android.feature_profile_api

import android.content.Context

// This is the external api used by other modules to start Profile Feature.

interface ProfileFeatureStarter {
    fun start(context: Context)
}