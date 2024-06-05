package com.atakanemre.Ecommerce.domain.usecases.home

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.Product
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<Unit, AppResult<Product>>() {
    override suspend fun execute(params: Unit): AppResult<Product> = productRepository.getProducts()
}