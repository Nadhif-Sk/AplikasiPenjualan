package com.example.aplikasipenjualan.ui.cart.add

import com.example.aplikasipenjualan.data.model.cart.ResponseCartUpdate

interface CartAddContract {
    interface Presenter {
        fun addCart(username: String, kd_produk: Long, jumlah: Long )
    }

    interface View{
        fun initActivity()
        fun initListener()
        fun onLoading(loading: Boolean)
        fun onResult(responseCartUpdate: ResponseCartUpdate)
        fun showMessage(message: String)
    }
}