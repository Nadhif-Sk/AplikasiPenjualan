package com.example.aplikasipenjualan.ui.agent.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipenjualan.R
import com.example.aplikasipenjualan.data.Constant
import com.example.aplikasipenjualan.data.model.agent.DataAgent
import com.example.aplikasipenjualan.utils.GlideHelper
import kotlinx.android.synthetic.main.adapter_agent_search.view.*

class AgentSearchAdapter (val context: Context, var dataAgent: ArrayList<DataAgent>,
                          val clickListener: (DataAgent, Int) -> Unit):
    RecyclerView.Adapter<AgentSearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.adapter_agent_search, parent,
        false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(dataAgent[position])
        GlideHelper.setImage(context, dataAgent[position].gambar_toko!!, holder.view.imvImage)

        holder.view.crvAgent.setOnClickListener {
            Constant.AGENT_ID = dataAgent[position].kd_agen!!
            clickListener(dataAgent[position], position)
        }
    }

    override fun getItemCount(): Int = dataAgent.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(dataAgent: DataAgent) {
            view.txvNameStore.text = dataAgent.nama_toko
            view.txvLocation.text = dataAgent.alamat
        }
    }

    fun setData(newDataAgent: List<DataAgent>){
        dataAgent.clear()
        dataAgent.addAll(newDataAgent)
        notifyDataSetChanged()
    }
}