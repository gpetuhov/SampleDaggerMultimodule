package com.gpetuhov.android.feature_first_impl.di.dependencies

import com.gpetuhov.android.core_utils.utils.Utils
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter

interface FirstFeatureDependencies {
    fun utils(): Utils

    // Notice that First Feature needs ProfileFeatureStarter
    // from feature-profile-api module to start ProfileActivity.
    fun profileFeatureStarter(): ProfileFeatureStarter
}