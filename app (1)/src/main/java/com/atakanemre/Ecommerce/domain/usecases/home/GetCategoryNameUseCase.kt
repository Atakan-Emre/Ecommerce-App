package com.atakanemre.Ecommerce.domain.usecases.home

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.Category
import javax.inject.Inject

class GetCategoryNameUseCase @Inject constructor(
    private val productRepository: ProductRepository
) :
    SuspendUseCase<Unit, AppResult<Category>>() {
    override suspend fun execute(params: Unit): AppResult<Category> =
        productRepository.getCategoryName()
}