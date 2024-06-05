package com.atakanemre.Ecommerce.domain.usecases.favoirte

import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.ProductEntity
import javax.inject.Inject

class GetFavoriteProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<Unit, List<ProductEntity>>() {
    override suspend fun execute(params: Unit): List<ProductEntity> =
        productRepository.getFavoriteProducts()
}