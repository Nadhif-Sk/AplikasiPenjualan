package com.example.aplikasipenjualan.data.model.product

import com.google.gson.annotations.SerializedName

data class ResponseProductList(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("data")
    val dataProduct: List<DataProduct>
)
