package com.atakanemre.Ecommerce.domain.usecases.favoirte

import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.ProductEntity
import javax.inject.Inject

class DeleteProductFromFavoriteUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<ProductEntity, Unit>() {
    override suspend fun execute(params: ProductEntity): Unit =
        productRepository.deleteFromFavorites(params)
}