package com.example.aplikasipenjualan.data.model.cart

import com.google.gson.annotations.SerializedName

data class ResponseCartUpdate(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("msg")
    val msg: String
)
