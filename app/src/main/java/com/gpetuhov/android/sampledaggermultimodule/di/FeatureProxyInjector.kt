package com.gpetuhov.android.sampledaggermultimodule.di

import com.gpetuhov.android.core_db_impl.di.components.CoreDbComponent
import com.gpetuhov.android.core_utils.di.components.CoreUtilsComponent
import com.gpetuhov.android.feature_first_api.FirstFeatureApi
import com.gpetuhov.android.feature_first_impl.di.components.DaggerFirstFeatureComponent_FirstFeatureDependenciesComponent
import com.gpetuhov.android.feature_first_impl.di.components.FirstFeatureComponent
import com.gpetuhov.android.feature_profile_api.ProfileFeatureApi
import com.gpetuhov.android.feature_profile_impl.di.components.DaggerProfileFeatureComponent_ProfileFeatureDependenciesComponent
import com.gpetuhov.android.feature_profile_impl.di.components.ProfileFeatureComponent
import com.gpetuhov.android.feature_second_api.SecondFeatureApi
import com.gpetuhov.android.feature_second_impl.di.components.DaggerSecondFeatureComponent_SecondFeatureDependenciesComponent
import com.gpetuhov.android.feature_second_impl.di.components.SecondFeatureComponent

// This class is a convenient wrapper around components initialization.
// This is where all modules interconnection is done.

class FeatureProxyInjector {
    companion object {

        fun getFeatureFirst(): FirstFeatureApi? {
            return FirstFeatureComponent.initAndGet(
                DaggerFirstFeatureComponent_FirstFeatureDependenciesComponent.builder()
                    .coreUtilsApi(CoreUtilsComponent.get())
                    .profileFeatureApi(getFeatureProfile()) // Notice that here we initialize FirstFeatureComponent with ProfileFeatureComponent
                    .build()
            )
        }

        fun getFeatureSecond(): SecondFeatureApi? {
            return SecondFeatureComponent.initAndGet(
                DaggerSecondFeatureComponent_SecondFeatureDependenciesComponent.builder()
                    .coreUtilsApi(CoreUtilsComponent.get())
                    .profileFeatureApi(getFeatureProfile())
                    .build()
            )
        }

        private fun getFeatureProfile(): ProfileFeatureApi? {
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