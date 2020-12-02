package com.igor.koindependency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

private const val PROF_NAME = "Name"

class MainActivity : AppCompatActivity(), MainContract.MainView {


    /**
     * paramentersOf() expression available in Koin , it allows to indicate input arguments for the object constructor and it will pass the required view to the presenter factory.
     */
    private val mPresenter : MainContract.MainPresenter by inject {  parametersOf(this)}

    private val preferences: AppPreferencesConstractor by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveName()
        printName()

    }
    fun saveName(){ preferences.saveProfileName(PROF_NAME) }
    fun printName(){ print(preferences.getProfileName())}


    override fun onStartView() {
        mPresenter.getProfileName().let {name ->
            preferences.saveProfileName(name)
            mPresenter.onComplete()
        }

    }

    override fun showData() {
        print(preferences.getProfileName())
    }
}