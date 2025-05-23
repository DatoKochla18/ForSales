package com.example.tbcexercises.data.mappers.favourite

import com.example.tbcexercises.data.local.entity.FavouriteProductEntity
import com.example.tbcexercises.domain.model.favourite.FavouriteProduct


fun FavouriteProductEntity.toDomainFavouriteProduct(): FavouriteProduct {
    return FavouriteProduct(
        productId = productId,
        productName = productName,
        productImgUrl = productImgUrl,
        company = company,
        productPrice = productPrice
    )
}