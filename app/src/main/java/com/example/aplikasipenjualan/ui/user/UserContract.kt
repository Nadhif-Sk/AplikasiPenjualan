package com.example.aplikasipenjualan.ui.user

import com.example.aplikasipenjualan.data.database.PrefsManager

interface UserContract {

    interface Presenter{
        fun doLogin(prefsManager: PrefsManager)
        fun doLogout(prefsManager: PrefsManager)
    }

    interface View{
        fun initActivity()
        fun initListener()
        fun onResultLogin(prefsManager: PrefsManager)
        fun onResultLogout()
        fun showMessage(message: String)
    }
}