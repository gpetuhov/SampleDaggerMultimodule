package com.gpetuhov.android.feature_first_example.di

import com.gpetuhov.android.core_utils.di.components.CoreUtilsComponent
import com.gpetuhov.android.core_utils.utils.Utils
import com.gpetuhov.android.feature_first_example.stubs.ProfileFeatureStarterStub
import com.gpetuhov.android.feature_first_impl.di.dependencies.FirstFeatureDependencies
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter

// This class instantiates stubs for the dependencies of the First Feature

class FirstFeatureDependenciesStub : FirstFeatureDependencies {

    override fun utils(): Utils {
        // We do not create stubs for Utils
        return CoreUtilsComponent.get()?.utils() ?: Utils()
    }

    override fun profileFeatureStarter(): ProfileFeatureStarter {
        // We instantiate ProfileFeatureStarterStub instead of ProfileFeatureStarterImpl
        return ProfileFeatureStarterStub()
    }
}