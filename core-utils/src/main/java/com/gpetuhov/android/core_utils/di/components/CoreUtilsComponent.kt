package com.gpetuhov.android.core_utils.di.components

import com.gpetuhov.android.core_utils.di.api.CoreUtilsApi
import com.gpetuhov.android.core_utils.di.modules.CoreUtilsModule
import dagger.Component
import javax.inject.Singleton

// Core modules instantiate classes with Singleton scope.

// This component implements CoreUtilsApi. That means that its declaration is the same as:
//abstract class CoreUtilsComponent {
//    fun utils(): Utils
//}
// And that tells Dagger, that components, which have CoreUtilsComponent as their dependency,
// will be also able to inject instance of the Utils class.

// Notice that the instance of CoreUtilsComponent is created as singleton
// right inside CoreUtilsComponent (inside the get() method),
// not in the Application class as usual.
// So to get CoreUtilsComponent instance and inject dependencies
// we shall call CoreUtilsComponent.get().inject(this),
// instead of something like App.coreUtilsComponent.inject(this).

// CoreUtilsComponent does not have inject() methods,
// otherwise it would have to know all the places, where it is used.
// To get instance of the Utils class, provided by CoreUtilsComponent,
// we should call utils() method of CoreUtilsApi.
// Which tells Dagger, that CoreUtilsComponent
// provides Utils class instance to the outer world.

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

        // As CoreUtilsComponent provides classes of Singleton scope
        // (which should live throughout all the application lifecycle),
        // we never clear it.
    }
}