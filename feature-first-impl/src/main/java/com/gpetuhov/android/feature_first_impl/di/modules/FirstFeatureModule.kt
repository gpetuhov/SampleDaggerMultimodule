package com.gpetuhov.android.feature_first_impl.di.modules

import com.gpetuhov.android.core_utils.di.scopes.PerFeature
import com.gpetuhov.android.feature_first_api.FirstFeatureStarter
import com.gpetuhov.android.feature_first_impl.start.FirstFeatureStarterImpl
import dagger.Module
import dagger.Provides

// Classes instantiated in Feature modules have PerFeature scope

@Module
class FirstFeatureModule {

    @Provides
    @PerFeature
    fun providesFirstFeatureStarter(): FirstFeatureStarter = FirstFeatureStarterImpl()
}