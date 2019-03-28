package com.gpetuhov.android.core_utils.dagger.components

import com.gpetuhov.android.core_utils.api.CoreUtilsApi
import com.gpetuhov.android.core_utils.dagger.modules.CoreUtilsModule
import dagger.Component
import javax.inject.Singleton

// Core modules instantiate classes with Singleton scope.

// This component implements CoreUtilsApi. That means that its declaration is the same as:
//abstract class CoreUtilsComponent {
//    fun utils(): Utils
//}
// And that tells Dagger, that components, which have CoreUtilsComponent as their dependency,
// will be also able to inject instance of the Utils class.

@Component(modules = [CoreUtilsModule::class])
@Singleton
abstract class CoreUtilsComponent : CoreUtilsApi {

    companion object {
        private var coreUtilsComponent: CoreUtilsComponent? = null

        fun get(): CoreUtilsComponent? {
            if (coreUtilsComponent == null) {
                coreUtilsComponent = DaggerCoreUtilsComponent.builder().build()
            }
            return coreUtilsComponent
        }
    }
}