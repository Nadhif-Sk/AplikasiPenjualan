package com.example.aplikasipenjualan.data.model.agent

import com.google.gson.annotations.SerializedName

data class ResponseAgentUpdate(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val msg: String
)
