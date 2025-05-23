package com.example.tbcexercises.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cart_product_entity",
    indices = [Index(value = ["productId", "company"], unique = true)]
)
data class CartProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productId: Int,
    val productName: String,
    val productImgUrl: String,
    val company: String,
    val productPrice: Double? = null,
    val productQuantity: Int? = 1
)