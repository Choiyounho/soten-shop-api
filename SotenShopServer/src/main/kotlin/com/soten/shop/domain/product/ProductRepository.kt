package com.soten.shop.domain.product

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, Long> {

	override fun findById(id: Long?): Optional<Product>

	fun findAllByOrderByIdDesc(): List<Product>

	fun findByCategoryIdAndIdGreaterThanOrderByIdDesc(
		categoryId: Int?, id: Long, pageable: Pageable
	): List<Product>

	fun findByCategoryIdAndIdLessThanOrderByIdDesc(
		categoryId: Int?, id: Long, pageable: Pageable
	): List<Product>

	fun findByIdGreaterThanAndNameLikeOrderByIdDesc(
		id: Long, keyword: String, pageable: Pageable
	): List<Product>

	fun findByIdLessThanAndNameLikeOrderByIdDesc(
		id: Long, keyword: String, pageable: Pageable
	): List<Product>

	fun findAllByCategoryIdOrderByIdDesc(categoryId: Int): List<Product>

}