package com.example.aplikasipenjualan.ui.home

class MainPresenter (val view: MainContract.View) {

    init {
        view.initListener()
    }
}