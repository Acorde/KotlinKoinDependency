package com.igor.koindependency

interface MainContract {

    interface MainView {
        fun onStartView()
        fun showData()
    }

    interface MainPresenter {
        val mView: MainView
        fun getProfileName(): String
        fun onComplete()
    }
}