package com.sepatu.shooees.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.databinding.ItemsProductBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listProducts = ArrayList<ProductEntity>()

    fun setProducts(product: List<ProductEntity>?) {
        if (product == null) return
        this.listProducts.clear()
        this.listProducts.addAll(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemProductBinding = ItemsProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemProductBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val product = listProducts[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = listProducts.size

    class HomeViewHolder(private val binding: ItemsProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductEntity) {
            with(binding) {
                tvTitle.text = product.name
                tvPrice.text = "Rp. " + product.price.toString()
                tvCategory.text = product.category
                Glide.with(itemView.context)
                    .load(product.image)
                    .into(imgProduct)
            }
        }
    }
}