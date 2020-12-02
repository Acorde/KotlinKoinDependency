package com.igor.koindependency

class MainPresenter constructor(override val mView: MainContract.MainView) :
    MainContract.MainPresenter {
    override fun getProfileName(): String {
        return "Name"
    }

    override fun onComplete() {
        mView.showData()
    }


}