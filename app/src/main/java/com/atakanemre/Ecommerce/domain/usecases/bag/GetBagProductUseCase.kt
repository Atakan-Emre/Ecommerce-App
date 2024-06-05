package com.atakanemre.Ecommerce.domain.usecases.bag

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.Product
import javax.inject.Inject

class GetBagProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<BagParams, AppResult<Product>>() {
    override suspend fun execute(params: BagParams): AppResult<Product> =
        productRepository.getBagProducts(params.userId)
}

data class BagParams(val userId: String)