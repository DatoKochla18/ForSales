package com.example.tbcexercises.presentation.favourite_screen.favorute_product_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbcexercises.R
import com.example.tbcexercises.databinding.ItemProductFavouriteBinding
import com.example.tbcexercises.domain.model.favourite.FavouriteProduct
import com.example.tbcexercises.utils.extension.loadImg
import com.example.tbcexercises.utils.extension.setTint

class FavouriteProductAdapter(val onClickToAddCart: (FavouriteProduct) -> Unit) :
    ListAdapter<FavouriteProduct, FavouriteProductAdapter.FavouriteProductViewHolder>(
        FavouriteProductDiffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteProductViewHolder {
        val binding =
            ItemProductFavouriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteProductViewHolder((binding))
    }

    override fun onBindViewHolder(holder: FavouriteProductViewHolder, position: Int) {
        holder.onBind()
    }


    inner class FavouriteProductViewHolder(val binding: ItemProductFavouriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {

            val favouriteProduct = getItem(bindingAdapterPosition)
            binding.apply {
                txtProductName.text = favouriteProduct.productName
                txtCompany.text = favouriteProduct.company
                txtPrice.text = root.context.getString(
                    R.string.money_format,
                    favouriteProduct.productPrice.toString()
                )
                imgAddToCart.setOnClickListener {
                    onClickToAddCart(favouriteProduct)
                }

                imgProduct.loadImg(favouriteProduct.productImgUrl)

                if (favouriteProduct.isAddedToCart) {
                    imgAddToCart.setTint(R.color.light_gray)
                } else {
                    imgAddToCart.setTint(R.color.black)
                }
            }
        }
    }

}