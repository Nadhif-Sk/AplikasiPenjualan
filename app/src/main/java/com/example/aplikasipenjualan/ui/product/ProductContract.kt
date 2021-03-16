package com.example.aplikasipenjualan.ui.product

import com.example.aplikasipenjualan.data.model.product.ResponseCategoryList
import com.example.aplikasipenjualan.data.model.product.ResponseProductList

interface ProductContract {
    interface Presenter {
        fun getCategory()
        fun getProduct(kd_kategori: Long)
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoading(loading: Boolean)
        fun onResultCategory(responseCategoryList: ResponseCategoryList)
        fun onResultProduct(responseProductList: ResponseProductList)
    }
}