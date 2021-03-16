package com.example.aplikasipenjualan.ui.home

interface MainContract {

    interface View{
        fun initListener()
        fun showMessage(message: String)
    }
}