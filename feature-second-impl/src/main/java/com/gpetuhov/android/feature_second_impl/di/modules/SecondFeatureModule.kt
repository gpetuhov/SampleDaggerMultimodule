package com.gpetuhov.android.feature_second_impl.di.modules

import com.gpetuhov.android.core_utils.di.scopes.PerFeature
import com.gpetuhov.android.feature_second_api.SecondFeatureStarter
import com.gpetuhov.android.feature_second_impl.start.SecondFeatureStarterImpl
import dagger.Module
import dagger.Provides

@Module
class SecondFeatureModule {

    @Provides
    @PerFeature
    fun providesSecondFeatureStarter(): SecondFeatureStarter = SecondFeatureStarterImpl()
}