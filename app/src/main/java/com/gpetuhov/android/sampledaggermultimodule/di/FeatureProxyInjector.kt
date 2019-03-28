package com.gpetuhov.android.sampledaggermultimodule.di

import com.gpetuhov.android.core_db_impl.di.components.CoreDbComponent
import com.gpetuhov.android.core_utils.di.components.CoreUtilsComponent
import com.gpetuhov.android.feature_profile_api.ProfileFeatureApi
import com.gpetuhov.android.feature_profile_impl.di.components.DaggerProfileFeatureComponent_ProfileFeatureDependenciesComponent
import com.gpetuhov.android.feature_profile_impl.di.components.ProfileFeatureComponent

// This class is a convenient wrapper around components initialization.
// This is where all modules interconnection is done.

class FeatureProxyInjector {
    companion object {
        fun getFeatureProfile(): ProfileFeatureApi? {
            // Create and initialize ProfileFeatureComponent with ProfileFeatureDependenciesComponent,
            // which implements ProfileFeatureDependencies, so it provides Utils and DbClientApi instances.
            return ProfileFeatureComponent.initAndGet(
                // Create and initialize ProfileFeatureDependenciesComponent with concrete
                // implementations of CoreUtilsApi and CoreDbApi,
                // which are in turn also are components,
                // so they provide Utils and DbClientApi instances respectively.
                DaggerProfileFeatureComponent_ProfileFeatureDependenciesComponent.builder()
                    .coreUtilsApi(CoreUtilsComponent.get())
                    .coreDbApi(CoreDbComponent.get())
                    .build()
            )
        }
    }
}