package com.example.aplikasipenjualan.ui.transaction.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipenjualan.R
import com.example.aplikasipenjualan.data.model.transaction.detail.DataDetail
import com.example.aplikasipenjualan.utils.GlideHelper
import kotlinx.android.synthetic.main.adapter_transaction_detail.view.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class TransactionDetailAdapter (val context: Context, var detail: ArrayList<DataDetail>):
    RecyclerView.Adapter<TransactionDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.adapter_transaction_detail, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(detail[position])
        GlideHelper.setImage(context, detail[position].gambar_produk!!, holder.view.imvImage)
    }

    override fun getItemCount(): Int = detail.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(detail: DataDetail) {
            view.txvCategory.text = detail.kategori
            view.txvNameProduct.text = detail.nama_produk
            view.txvPrice.text = "${detail.harga_rupiah} x ${detail.jumlah} "

            val total: Double = detail!!.jumlah!!.toDouble() * detail.harga!!.toDouble()
            val totalRupiah: String = NumberFormat.getNumberInstance(Locale.GERMAN).format(total)
            view.txvTotal.text = "Rp. $totalRupiah"
        }
    }

    fun setData(newDetail: List<DataDetail>){
        detail.clear()
        detail.addAll(newDetail)
        notifyDataSetChanged()
    }
}