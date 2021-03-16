package com.example.aplikasipenjualan.ui.agent.search

import com.example.aplikasipenjualan.data.model.agent.ResponseAgentList
import com.example.aplikasipenjualan.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AgentSearchPresenter(val view: AgentSearchContract.View) : AgentSearchContract.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }

    override fun getAgent() {
        view.onLoadingAgent(true)
        ApiService.endpoint.getAgent()
                .enqueue(object : Callback<ResponseAgentList> {
                    override fun onResponse(
                            call: Call<ResponseAgentList>,
                            response: Response<ResponseAgentList>
                    ) {
                        view.onLoadingAgent(false)
                        if (response.isSuccessful) {
                            val responseAgent: ResponseAgentList? = response.body()
                            view.onResultAgent(responseAgent!!)
                        }
                    }

                    override fun onFailure(call: Call<ResponseAgentList>, t: Throwable) {
                        view.onLoadingAgent(false)
                    }
                })
    }

    override fun searchAgent(keyword: String) {
        view.onLoadingAgent(true)
        ApiService.endpoint.searchAgent(keyword)
                .enqueue(object : Callback<ResponseAgentList> {
                    override fun onResponse(
                            call: Call<ResponseAgentList>,
                            response: Response<ResponseAgentList>
                    ) {
                        view.onLoadingAgent(false)
                        if (response.isSuccessful) {
                            val responseAgent: ResponseAgentList? = response.body()
                            view.onResultAgent(responseAgent!!)
                        }
                    }

                    override fun onFailure(call: Call<ResponseAgentList>, t: Throwable) {
                        view.onLoadingAgent(false)
                    }
                })
    }
}