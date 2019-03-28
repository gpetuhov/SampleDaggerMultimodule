package com.gpetuhov.android.core_db_impl.data

import com.gpetuhov.android.core_db_api.data.DbClientApi
import com.gpetuhov.android.core_db_api.models.User

// DbClientImpl implements DbClientApi interface.
// Core-db-impl module provide DbClientImpl to other modules,
// but they will use it as DbClientApi, because only api module
// can be accessed from the outside, so the outside knows only about DbClientApi.

class DbClientImpl : DbClientApi {
    override fun getUser(): User {
        // "Get current user from the database"
        return User("John", "john@connor.com")
    }
}