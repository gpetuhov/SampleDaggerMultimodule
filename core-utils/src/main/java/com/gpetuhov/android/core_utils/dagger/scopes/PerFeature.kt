package com.gpetuhov.android.core_utils.dagger.scopes

import javax.inject.Scope

// Application has 3 scopes: Singleton (provided by default), PerFeature and PerScreen.
// PerFeature and PerScreen scopes are declared in core-utils module,
// so that they can be used in any module of the application.

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFeature