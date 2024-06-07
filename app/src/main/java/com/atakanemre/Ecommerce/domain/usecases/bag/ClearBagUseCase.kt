package com.atakanemre.Ecommerce.domain.usecases.bag

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.CRUD
import com.atakanemre.Ecommerce.model.ClearBagBody
import javax.inject.Inject

class ClearBagUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<ClearBagBody, AppResult<CRUD>>() {
    override suspend fun execute(params: ClearBagBody): AppResult<CRUD> =
        productRepository.clearBag(params)
}