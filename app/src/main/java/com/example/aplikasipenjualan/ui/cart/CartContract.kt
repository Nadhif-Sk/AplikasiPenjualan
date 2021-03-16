package com.example.aplikasipenjualan.ui.cart

import com.example.aplikasipenjualan.data.model.cart.ResponseCartList
import com.example.aplikasipenjualan.data.model.cart.ResponseCartUpdate
import com.example.aplikasipenjualan.data.model.cart.ResponseCheckout

interface CartContract {
    interface Presenter {
        fun getCart(username: String)

        fun deleteItemCart(kd_keranjang: Long)
        fun deleteCart(username: String)

        fun checkOut(username: String, kd_agent: Long)
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoadingCart(loading: Boolean)
        fun onResultCart(responseCartList: ResponseCartList)
        fun showMessage(message: String)

        fun onResultDelete(responseCartUpdate: ResponseCartUpdate)
        fun showDialog()

        fun onLoadingCheckout(loading: Boolean)
        fun onResultCheckout(responseCheckout: ResponseCheckout)
    }
}
