package com.soten.shop.domain.product

import com.soten.shop.common.ShopException

data class ProductResponse(
    val id: Long,
    val name: String,
    val description: String,
    val price: Int,
    val status: String,
    val sellerId: Long,
    val imagePaths: List<String>
)

fun Product.toProductResponse() = id?.let { it ->
    ProductResponse(
        it,
        name,
        description,
        price,
        status.name,
        userId,
        images.map { it.path }
    )
} ?: throw ShopException("상품 정보를 찾을 수 없습니다.")