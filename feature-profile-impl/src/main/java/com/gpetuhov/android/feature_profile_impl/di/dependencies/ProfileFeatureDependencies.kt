package com.gpetuhov.android.feature_profile_impl.di.dependencies

import com.gpetuhov.android.core_db_api.data.DbClientApi
import com.gpetuhov.android.core_utils.utils.Utils

// These are the dependencies of the Profile Feature module
// (it needs Utils and DbClientApi instances).

interface ProfileFeatureDependencies {
    fun utils(): Utils
    fun dbClient(): DbClientApi
}