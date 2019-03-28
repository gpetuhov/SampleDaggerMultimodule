package com.gpetuhov.android.core_db_api.di

import com.gpetuhov.android.core_db_api.data.DbClientApi

// This interface tells other modules, what this module provides to the outer world.

interface CoreDbApi {
    fun dbClientApi(): DbClientApi
}