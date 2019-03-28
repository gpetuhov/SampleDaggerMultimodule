package com.gpetuhov.android.core_db_api.data

import com.gpetuhov.android.core_db_api.models.User

// This is the api of the database client, provided by core-db module.
// DbClientImpl in core-db-impl module implements this interface.
// DbClientApi is inside core-db-api module, so that other modules
// will know, what they can do with database client.

interface DbClientApi {
    fun getUser(): User
}