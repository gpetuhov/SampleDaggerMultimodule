package com.gpetuhov.android.feature_second_impl.di.dependencies

import com.gpetuhov.android.core_utils.utils.Utils
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter

// In this example Second Feature has the same dependencies as the First one,
// but in real project different Features dependencies will most probably be different.

interface SecondFeatureDependencies {
    fun utils(): Utils
    fun profileFeatureStarter(): ProfileFeatureStarter
}