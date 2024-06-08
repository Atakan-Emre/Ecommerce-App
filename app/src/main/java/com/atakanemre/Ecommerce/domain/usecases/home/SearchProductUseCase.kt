package com.atakanemre.Ecommerce.domain.usecases.home

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.Product
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<SearchProductParams, AppResult<Product>>() {
    override suspend fun execute(params: SearchProductParams): AppResult<Product> =
        productRepository.searchProduct(params.query)
}

data class SearchProductParams(val query: String)