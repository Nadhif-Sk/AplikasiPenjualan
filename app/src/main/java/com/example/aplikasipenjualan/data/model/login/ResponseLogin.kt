package com.example.aplikasipenjualan.data.model.login

import com.example.aplikasipenjualan.data.model.login.DataLogin
import com.google.gson.annotations.SerializedName

data class ResponseLogin(

    @SerializedName("status")
    val status : Boolean,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("pegawai")
    val pegawai: DataLogin?
)
