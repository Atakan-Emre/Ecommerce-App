package com.atakanemre.Ecommerce.domain.usecases.bag

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.CRUD
import javax.inject.Inject

class DeleteToProductFromBagUseCase @Inject constructor(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<Int, AppResult<CRUD>>() {
    override suspend fun execute(params: Int): AppResult<CRUD> =
        productRepository.deleteToProductFromBag(params)
}