package com.example.aplikasipenjualan.ui.agent.search

import com.example.aplikasipenjualan.data.model.agent.ResponseAgentList

interface AgentSearchContract {
    interface Presenter {
        fun getAgent()
        fun searchAgent(keyword: String)
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoadingAgent(loading: Boolean)
        fun onResultAgent(responseAgentList: ResponseAgentList)
    }
}