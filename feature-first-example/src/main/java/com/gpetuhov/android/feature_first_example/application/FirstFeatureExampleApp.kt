package com.gpetuhov.android.feature_first_example.application

import android.app.Application
import com.gpetuhov.android.feature_first_example.di.FirstFeatureDependenciesStub
import com.gpetuhov.android.feature_first_impl.di.components.FirstFeatureComponent

// feature-first-example module demonstrates, how we can use First Feature Module in isolation,
// without Profile Feature Module (for example for testing, or in another project).

// FirstFeatureComponent depends on FirstFeatureStarter, so we have to provide stub for it.

// We do not provide stub for Utils and use real Utils class, provided by CoreUtilsComponent
// (because utility classes may be similar in different projects).

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