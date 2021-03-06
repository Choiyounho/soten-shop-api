package com.soten.shop.product.dto

data class ProductRegistrationRequest(
    val name: String,
    val description: String,
    val price: Int,
    val categoryId: Int,
    val images: List<String>,
    val userId: Int
)
