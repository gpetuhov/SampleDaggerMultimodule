package com.gpetuhov.android.feature_second_impl.di.components

import com.gpetuhov.android.core_utils.di.api.CoreUtilsApi
import com.gpetuhov.android.core_utils.di.scopes.PerFeature
import com.gpetuhov.android.feature_profile_api.ProfileFeatureApi
import com.gpetuhov.android.feature_second_api.SecondFeatureApi
import com.gpetuhov.android.feature_second_impl.di.dependencies.SecondFeatureDependencies
import com.gpetuhov.android.feature_second_impl.di.modules.SecondFeatureModule
import com.gpetuhov.android.feature_second_impl.ui.SecondFeatureActivity
import dagger.Component

@Component(
    modules = [SecondFeatureModule::class],
    dependencies = [SecondFeatureDependencies::class]
)
@PerFeature
abstract class SecondFeatureComponent : SecondFeatureApi {

    companion object {
        private var secondFeatureComponent: SecondFeatureComponent? = null

        fun initAndGet(secondFeatureDependencies: SecondFeatureDependencies): SecondFeatureApi? {
            if (secondFeatureComponent == null) {
                secondFeatureComponent = DaggerSecondFeatureComponent.builder()
                    .secondFeatureDependencies(secondFeatureDependencies)
                    .build()
            }
            return secondFeatureComponent
        }

        fun get(): SecondFeatureComponent? {
            if (secondFeatureComponent == null) {
                throw RuntimeException("You must call 'initAndGet()' method")
            }
            return secondFeatureComponent
        }

        fun resetComponent() {
            secondFeatureComponent = null
        }
    }

    abstract fun inject(secondFeatureActivity: SecondFeatureActivity)

    @Component(dependencies = [
        CoreUtilsApi::class,
        ProfileFeatureApi::class
    ])
    @PerFeature
    interface SecondFeatureDependenciesComponent : SecondFeatureDependencies
}