package com.example.aplikasipenjualan.ui.cart

import com.example.aplikasipenjualan.data.model.cart.ResponseCartList
import com.example.aplikasipenjualan.data.model.cart.ResponseCartUpdate
import com.example.aplikasipenjualan.data.model.cart.ResponseCheckout
import com.example.aplikasipenjualan.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartPresenter(val view: CartContract.View) : CartContract.Presenter {
    init {
        view.initActivity()
        view.initListener()
    }

    override fun getCart(username: String) {
        view.onLoadingCart(true)
        ApiService.endpoint.getCart(username)
            .enqueue(object : Callback<ResponseCartList> {
                override fun onResponse(
                    call: Call<ResponseCartList>,
                    response: Response<ResponseCartList>
                ) {
                    view.onLoadingCart(false)
                    if (response.isSuccessful) {
                        val responseCartList: ResponseCartList? = response.body()
                        responseCartList?.let { data ->
                            view.onResultCart(data)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseCartList>, t: Throwable) {
                    view.onLoadingCart(false)
                }
            })
    }

    override fun deleteItemCart(kd_keranjang: Long) {
        ApiService.endpoint.deleteItemCart(kd_keranjang)
            .enqueue(object : Callback<ResponseCartUpdate> {
                override fun onResponse(
                    call: Call<ResponseCartUpdate>,
                    response: Response<ResponseCartUpdate>
                ) {
                    if (response.isSuccessful) {
                        val responseCartUpdate: ResponseCartUpdate? = response.body()
                        view.onResultDelete(responseCartUpdate!!)
                    }
                }

                override fun onFailure(call: Call<ResponseCartUpdate>, t: Throwable) {}
            })
    }

    override fun deleteCart(username: String) {
        ApiService.endpoint.deleteCart(username)
            .enqueue(object : Callback<ResponseCartUpdate> {
                override fun onResponse(
                    call: Call<ResponseCartUpdate>,
                    response: Response<ResponseCartUpdate>
                ) {
                    if (response.isSuccessful) {
                        val responseCartUpdate: ResponseCartUpdate? = response.body()
                        view.onResultDelete(responseCartUpdate!!)
                        view.showMessage(responseCartUpdate.msg)
                    }
                }

                override fun onFailure(call: Call<ResponseCartUpdate>, t: Throwable) {}
            })
    }

    override fun checkOut(username: String, kd_agen: Long) {
        view.onLoadingCheckout(true)
        ApiService.endpoint.checkOut(username, kd_agen)
                .enqueue(object : Callback<ResponseCheckout> {
                    override fun onResponse(
                            call: Call<ResponseCheckout>,
                            response: Response<ResponseCheckout>
                    ) {
                        view.onLoadingCheckout(false)
                        if (response.isSuccessful) {
                            val responseCheckout: ResponseCheckout? = response.body()
                            view.onResultCheckout(responseCheckout!!)
                            view.showMessage(responseCheckout.msg)
                        }
                    }

                    override fun onFailure(call: Call<ResponseCheckout>, t: Throwable) {
                        view.onLoadingCheckout(false)
                    }
                })
    }
}
