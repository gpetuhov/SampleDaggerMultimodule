package com.gpetuhov.android.feature_first_example.application

import android.app.Application
import com.gpetuhov.android.feature_first_example.di.FirstFeatureDependenciesStub
import com.gpetuhov.android.feature_first_impl.di.components.FirstFeatureComponent

class FirstFeatureExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize FirstFeatureComponent here,
        // because this application module starts FirstFeatureActivity
        // as its first and only activity (in the manifest).
        FirstFeatureComponent.initAndGet(
            // Instead of FirstFeatureDependenciesComponent,
            // we pass FirstFeatureDependenciesStub (Dagger can handle this).
            FirstFeatureDependenciesStub()
        )
    }
}