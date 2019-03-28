package com.gpetuhov.android.feature_first_impl.di.components

import com.gpetuhov.android.core_utils.di.api.CoreUtilsApi
import com.gpetuhov.android.core_utils.di.scopes.PerFeature
import com.gpetuhov.android.feature_first_api.FirstFeatureApi
import com.gpetuhov.android.feature_first_impl.di.dependencies.FirstFeatureDependencies
import com.gpetuhov.android.feature_first_impl.di.modules.FirstFeatureModule
import com.gpetuhov.android.feature_first_impl.ui.FirstFeatureActivity
import com.gpetuhov.android.feature_profile_api.ProfileFeatureApi
import dagger.Component

@Component(
    modules = [FirstFeatureModule::class],
    dependencies = [FirstFeatureDependencies::class]
)
@PerFeature
abstract class FirstFeatureComponent : FirstFeatureApi {

    companion object {
        private var firstFeatureComponent: FirstFeatureComponent? = null

        fun initAndGet(firstFeatureDependencies: FirstFeatureDependencies): FirstFeatureApi? {
            if (firstFeatureComponent == null) {
                firstFeatureComponent = DaggerFirstFeatureComponent.builder()
                    .firstFeatureDependencies(firstFeatureDependencies)
                    .build()
            }
            return firstFeatureComponent
        }

        fun get(): FirstFeatureComponent? {
            if (firstFeatureComponent == null) {
                throw RuntimeException("You must call 'initAndGet()' method")
            }
            return firstFeatureComponent
        }

        fun resetComponent() {
            firstFeatureComponent = null
        }
    }

    abstract fun inject(firstFeatureActivity: FirstFeatureActivity)

    @Component(dependencies = [
        CoreUtilsApi::class,
        ProfileFeatureApi::class
    ])
    @PerFeature
    interface FirstFeatureDependenciesComponent : FirstFeatureDependencies
}