package com.example.aplikasipenjualan.data.model.agent

import com.example.aplikasipenjualan.data.model.agent.DataAgent
import com.google.gson.annotations.SerializedName

class ResponseAgentList(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("data")
        val dataAgent: List<DataAgent>
)

