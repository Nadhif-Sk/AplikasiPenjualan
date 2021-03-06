package com.example.aplikasipenjualan.ui.transaction.detail


import com.example.aplikasipenjualan.data.model.transaction.detail.ResponseTransactionDetail

interface TransactionDetailContract {
    interface Presenter {
        fun getTransactionByInvoice(invoice: String)
    }

    interface View {
        fun initFragment()
        fun initListener(view: android.view.View)
        fun onLoading(loading: Boolean)
        fun onResult(responseTransactionDetail: ResponseTransactionDetail)
    }
}