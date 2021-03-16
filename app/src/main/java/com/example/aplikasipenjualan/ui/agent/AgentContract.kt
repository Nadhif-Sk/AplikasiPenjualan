package com.example.aplikasipenjualan.ui.agent

import com.example.aplikasipenjualan.data.model.agent.DataAgent
import com.example.aplikasipenjualan.data.model.agent.ResponseAgentList
import com.example.aplikasipenjualan.data.model.agent.ResponseAgentUpdate

interface AgentContract {

    interface Presenter{
        fun getAgent()
        fun deleteAgent(kd_agent: Long)
    }

    interface View{
        fun initActivity()
        fun initListener()
        fun onLoadingAgent(loading: Boolean)
        fun onResultAgent(responseAgentList: ResponseAgentList)
        fun onResultDelete(responseAgentUpdate: ResponseAgentUpdate)
        fun showDialogDelete(dataAgent: DataAgent, position: Int)
        fun showDialogDetail(dataAgent: DataAgent, position: Int)
        fun showMessage(message: String)
    }
}