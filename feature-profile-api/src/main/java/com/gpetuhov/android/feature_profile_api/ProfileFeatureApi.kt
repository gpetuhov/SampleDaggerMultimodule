package com.gpetuhov.android.feature_profile_api

// This is what other modules can get from Profile Feature module.
// (they can only get ProfileFeatureStarter to start Profile Feature and that's all)

interface ProfileFeatureApi {
    fun profileFeatureStarter(): ProfileFeatureStarter
}