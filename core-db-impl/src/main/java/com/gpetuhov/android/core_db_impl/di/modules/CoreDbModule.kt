package com.gpetuhov.android.core_db_impl.di.modules

import com.gpetuhov.android.core_db_api.data.DbClientApi
import com.gpetuhov.android.core_db_impl.data.DbClientImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreDbModule {

    // Notice that this method provides DbClientImpl as DbClientApi
    @Provides
    @Singleton
    fun providesDbClientApi(): DbClientApi = DbClientImpl()
}