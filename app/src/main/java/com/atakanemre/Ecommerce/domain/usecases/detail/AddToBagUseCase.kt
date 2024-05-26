package com.atakanemre.Ecommerce.domain.usecases.detail

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.AddToCardRequest
import com.atakanemre.Ecommerce.model.CRUD
import javax.inject.Inject

class AddToBagUseCase @Inject constructor(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<AddToCardRequest, AppResult<CRUD>>() {
    override suspend fun execute(params: AddToCardRequest): AppResult<CRUD> =
        productRepository.addToBag(params)
}