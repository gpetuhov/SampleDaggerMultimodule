package com.gpetuhov.android.feature_profile_impl.di.components

import com.gpetuhov.android.core_db_api.di.CoreDbApi
import com.gpetuhov.android.core_utils.di.api.CoreUtilsApi
import com.gpetuhov.android.core_utils.di.scopes.PerFeature
import com.gpetuhov.android.feature_profile_api.ProfileFeatureApi
import com.gpetuhov.android.feature_profile_impl.di.dependencies.ProfileFeatureDependencies
import com.gpetuhov.android.feature_profile_impl.di.modules.ProfileFeatureModule
import dagger.Component

// ProfileFeatureComponent provides class instances with PerFeature scope.

// ProfileFeatureComponent depends on ProfileFeatureDependencies
// (Dagger allows using interfaces, not only components),
// so it can provide instances of Utils and DbClientApi.

// We have 2 (!!!) components here:
// ProfileFeatureComponent and ProfileFeatureDependenciesComponent.
// ProfileFeatureComponent depends on ProfileFeatureDependencies interface,
// which is implemented by ProfileFeatureDependenciesComponent component.

// But we need to initialize ProfileFeatureDependenciesComponent with concrete
// implementations of CoreUtilsApi and CoreDbApi and provide this concrete
// ProfileFeatureDependenciesComponent to ProfileFeatureComponent.
// We cannot do it here, because from the Feature module we have access
// only to api modules. That's why this is done in the application module,
// which has access both to api and impl modules.

// This allows us to have such an architecture, where Features know nothing
// of each other's implementation, only external apis.
// All interconnection is done in the application module, which is the only one
// that has access both to api and impl modules.

@Component(
    modules = [ProfileFeatureModule::class],
    dependencies = [ProfileFeatureDependencies::class]  // Dagger allows using interfaces here, not only components
)
@PerFeature
abstract class ProfileFeatureComponent : ProfileFeatureApi {

    companion object {
    }

    // ProfileFeatureDependenciesComponent depends on CoreUtilsApi and CoreDbApi,
    // so it can provide instances of Utils and DbClientApi.
    // ProfileFeatureDependenciesComponent implements ProfileFeatureDependencies,
    // which is equivalent to:
    // interface ProfileFeatureDependenciesComponent {
    //     fun utils(): Utils
    //     fun dbClientApi(): DbClientApi
    // }
    // So components, that depend on ProfileFeatureDependenciesComponent,
    // can also provide instances of Utils and DbClientApi.

    // Notice that we have a component inside a component here.
    // Dagger can handle this!

    @Component(dependencies = [
        CoreUtilsApi::class,    // Dagger allows interfaces here
        CoreDbApi::class
    ])
    @PerFeature
    interface ProfileFeatureDependenciesComponent : ProfileFeatureDependencies
}