package com.example.aplikasipenjualan.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipenjualan.R
import com.example.aplikasipenjualan.data.model.cart.DataCart
import com.example.aplikasipenjualan.utils.GlideHelper
import kotlinx.android.synthetic.main.adapter_cart.view.*
import kotlinx.android.synthetic.main.adapter_transaction.view.txvTotal
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class CartAdapter (val context: Context, var cart: ArrayList<DataCart>,
                   val clickListener: (DataCart, Int) -> Unit):
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.adapter_cart, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(cart[position])
        GlideHelper.setImage(context, cart[position].gambar_produk!!, holder.view.imvImage)
        holder.view.imvDelete.setOnClickListener {
            clickListener(cart[position], position)
            removeCart(position)
        }
    }

    override fun getItemCount(): Int = cart.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(cart: DataCart) {
            view.txvCategory.text = cart.kategori
            view.txvNameProduct.text = cart.nama_produk
            view.txvPrice.text = "${cart.harga_rupiah} x ${cart.jumlah}"

            val total: Double = cart!!.jumlah!!.toDouble() * cart.harga!!.toDouble()
            val totalRupiah: String = NumberFormat.getNumberInstance(Locale.GERMAN).format(total)
            view.txvTotal.text = "Rp. $totalRupiah"
        }
    }

    fun setData(newCart: List<DataCart>){
        cart.clear()
        cart.addAll(newCart)
        notifyDataSetChanged()
    }

    fun removeCart(position: Int){
        cart.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, cart.size)
    }

    fun removeAll(){
        cart.clear()
        notifyDataSetChanged()
    }
}