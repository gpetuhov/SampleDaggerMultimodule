package com.gpetuhov.android.core_utils.di.modules

import com.gpetuhov.android.core_utils.utils.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// Core modules instantiate classes with Singleton scope

@Module
class CoreUtilsModule {

    @Provides
    @Singleton
    fun providesUtils() = Utils()
}