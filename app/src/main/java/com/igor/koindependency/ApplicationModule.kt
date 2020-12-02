package com.igor.koindependency

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {
    /**
     * single provides a unique instance during the entire application
     */
    single { AppPreferencesConstractor(androidContext()) } // Constructor injection.

    single { AppPreferencesKoinComponent() } // KoinComponent

    /**
     * factory will provide a new instance of the requested dependency every time it needs to be injected.
     */
    factory<MainContract.MainPresenter> { (mView: MainContract.MainView) ->
        MainPresenter(mView)
    }
}