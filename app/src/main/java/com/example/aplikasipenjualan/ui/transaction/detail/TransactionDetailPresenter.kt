package com.example.aplikasipenjualan.ui.transaction.detail

import com.example.aplikasipenjualan.data.model.transaction.detail.ResponseTransactionDetail
import com.example.aplikasipenjualan.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionDetailPresenter (val view: TransactionDetailContract.View):
    TransactionDetailContract.Presenter {

    init {
        view.initFragment()
    }

    override fun getTransactionByInvoice(invoice: String) {
        view.onLoading(true)
        ApiService.endpoint.getTransactionByInvoice(invoice)
            .enqueue(object : Callback<ResponseTransactionDetail>{
                override fun onResponse(
                    call: Call<ResponseTransactionDetail>,
                    responseTransaction: Response<ResponseTransactionDetail>
                ) {
                    view.onLoading(false)
                    if (responseTransaction.isSuccessful){
                        val responseTransactionDetail: ResponseTransactionDetail? = responseTransaction.body()
                        view.onResult(responseTransactionDetail!!)
                    }
                }

                override fun onFailure(call: Call<ResponseTransactionDetail>, t: Throwable) {
                    view.onLoading(false)
                }

            })
    }
}