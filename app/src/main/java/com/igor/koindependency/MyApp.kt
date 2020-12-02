package com.igor.koindependency

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * For Koin we can have 3 types of scope. We can define it as:
    single: ->  which is a singleton, this type of scope will persist for the entire application lifetime.
    factory: -> for this type, Koin will provide a new object for each time we require an instance.
    scoped: -> in this case, Koinwill provides an object that will persist as long the associated scope lifetime exists.
    In this tutorial, we will only talk about single and factory .
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKotlin()

    }

    /**
     * This function is responsible to return a KoinApplication instance
     */
    private fun initKotlin() {
        startKoin {
            androidLogger(Level.DEBUG) //is used to set the Koin log level.
            androidContext(this@MyApp)
            modules(listOf(applicationModule))
        }
    }
}