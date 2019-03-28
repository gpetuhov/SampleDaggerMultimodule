package com.gpetuhov.android.core_db_impl.di.components

import com.gpetuhov.android.core_db_api.di.CoreDbApi
import com.gpetuhov.android.core_db_impl.di.modules.CoreDbModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CoreDbModule::class])
@Singleton
abstract class CoreDbComponent : CoreDbApi {

    companion object {
        private var coreDbComponent: CoreDbComponent? = null

        fun get(): CoreDbComponent? {
            if (coreDbComponent == null) {
                coreDbComponent = DaggerCoreDbComponent.builder().build()
            }
            return coreDbComponent
        }
    }
}