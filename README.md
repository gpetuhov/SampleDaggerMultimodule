# SampleDaggerMultimodule
Learn how to create clean architecture multimodule Android project with Dagger 2.

This example is about horizontal organization of the project into modules. Each module itself can be organized into layers based on the Clean Architecture principles (not shown in this sample).

## Requirements
* Android Studio 3.5 Canary 8
* Kotlin 1.3.21
* Android Gradle Plugin 3.5.0-alpha08
* Gradle wrapper 5.3-rc-2
* AAPT 2

## Notes
* Application consists of Core and Feature modules. Core modules provide common functionality for Feature modules. Core modules cannot use any other modules. Feature modules are independent parts of the application. Feature modules can use only Core modules and other Feature modules.

* Core and Feauture modules are divided into 2 parts (modules): api and impl. Api module tells the outer world, what parts of the module can be used. Impl module is the implementation of Core or Feature logic.

* Api modules are completely isolated, they cannot use any other modules.

* Impl modules can use only api modules and cannot use impl modules (so that modules can't see implementations of other modules). Core-impl modules can use only their core-api modules. Feature-impl modules can use their feature-api modules, feature-api modules of other Features and core-api modules.

* Core-utils module is not divided into api and impl, because of its simplicity.

* Module interconnection is done in the Application (app module), where apis are substituted by concrete implementations. So app module can use both api and impl modules of Cores and Features.

* Application should contain only 3 scopes: Singleton, PerFeature and PerScreen. Instances with Singleton scope live throughout the application lifecycle. Instances with PerFeature scope live throughout feature lifecycle. Instances with PerScreen feature live throughout screen lifecycle.

* This sample application has 2 Core modules: utils and db. Core-utils contains some common logic (returns app title). Core-db gets current from the "database" (just returns instance of the User class). Core-db is divided into core-db-api and core-db-impl modules.

* This sample application has 3 Feature modules: First, Second and Profile. Profile feature can be started from the MainActivity and also both from the First and Second Features. So First and Second Feature modules must know about feature-profile-api module. 

## References
https://habr.com/ru/company/kaspersky/blog/422555/

https://github.com/matzuk/Clean-multimodel-arch