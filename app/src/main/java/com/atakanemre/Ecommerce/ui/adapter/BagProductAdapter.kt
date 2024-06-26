package com.atakanemre.Ecommerce.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atakanemre.Ecommerce.R
import com.atakanemre.Ecommerce.databinding.BagItemBinding
import com.atakanemre.Ecommerce.model.ProductX
import com.atakanemre.Ecommerce.util.downloadFromUrl

class BagProductAdapter(private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<BagProductAdapter.BagViewHolder>() {

    private val bagProductList = ArrayList<ProductX>()

    inner class BagViewHolder(private val binding: BagItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bagProduct: ProductX) {
            with(binding) {
                bagItemTitleTv.text = bagProduct.title
                bagItemPriceTv.text =
                    binding.root.context.getString(R.string.price, bagProduct.price.toString())
                bagItemIv.downloadFromUrl(bagProduct.imageOne)
                if (bagProduct.saleState) {
                    bagItemSalePriceTv.visibility = View.VISIBLE
                    bagItemSalePriceTv.text =
                        binding.root.context.getString(
                            R.string.price,
                            bagProduct.salePrice.toString()
                        )
                    bagItemPriceTv.setBackgroundResource(R.drawable.discount_line)
                } else {
                    bagItemSalePriceTv.visibility = View.GONE
                    bagItemPriceTv.background = null
                }
                bagItemDeleteIv.setOnClickListener {
                    onClick.invoke(bagProduct.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagViewHolder {
        val binding = BagItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BagViewHolder(binding)
    }

    override fun getItemCount(): Int = bagProductList.size

    override fun onBindViewHolder(holder: BagViewHolder, position: Int) {
        val bagProduct = bagProductList[position]
        holder.bind(bagProduct)
    }

    fun updateProductList(updateBagProductList: List<ProductX>) {
        bagProductList.clear()
        bagProductList.addAll(updateBagProductList)
        notifyDataSetChanged()
    }
}