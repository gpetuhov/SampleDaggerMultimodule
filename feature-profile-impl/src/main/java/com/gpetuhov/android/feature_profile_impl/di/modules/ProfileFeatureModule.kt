package com.gpetuhov.android.feature_profile_impl.di.modules

import com.gpetuhov.android.core_utils.di.scopes.PerFeature
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter
import com.gpetuhov.android.feature_profile_impl.start.ProfileFeatureStarterImpl
import dagger.Module
import dagger.Provides

// ProfileFeatureModule provides instances with PerFeature scope

@Module
class ProfileFeatureModule {

    @Provides
    @PerFeature
    fun providesProfileFeatureStarter(): ProfileFeatureStarter = ProfileFeatureStarterImpl()
}