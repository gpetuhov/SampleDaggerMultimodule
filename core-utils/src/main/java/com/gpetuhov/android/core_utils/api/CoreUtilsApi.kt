package com.gpetuhov.android.core_utils.api

import com.gpetuhov.android.core_utils.utils.Utils

// This is the API of Core-utils module.
// It is contained inside core-utils module, because of Core-utils simplicity.
// Apis of other Core and Feature modules is extracted into separate modules.

// Api tells other modules, what they can use from the current module.
// Here we tell other modules, that they can use only Utils class from this module.

interface CoreUtilsApi {
    fun utils(): Utils
}