package com.example.aplikasipenjualan.ui.product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipenjualan.R
import com.example.aplikasipenjualan.data.Constant
import com.example.aplikasipenjualan.data.model.product.DataCategory
import com.example.aplikasipenjualan.utils.GlideHelper
import kotlinx.android.synthetic.main.adapter_category.view.*
import kotlin.collections.ArrayList

class CategoryAdapter (val context: Context, var category: ArrayList<DataCategory>,
                       val clicklistener: (DataCategory, Int) -> Unit ):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.adapter_category, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(category[position])
        GlideHelper.setImage(context, category[position].gambar_kategori!!, holder.view.imvImage)
        holder.view.relCategory.setOnClickListener {
            Constant.CATEGORY_ID = category[position].kd_kategori!!
            clicklistener(category[position], position)
        }
    }

    override fun getItemCount(): Int = category.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(category: DataCategory) {
            view.txvCategory.text = category.kategori
        }
    }

    fun setData(newCategory: List<DataCategory>){
        category.clear()
        category.addAll(newCategory)
        notifyDataSetChanged()
    }
}