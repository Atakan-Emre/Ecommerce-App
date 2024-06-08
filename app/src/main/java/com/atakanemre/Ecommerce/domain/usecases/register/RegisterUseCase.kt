package com.atakanemre.Ecommerce.domain.usecases.register

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.CRUD
import com.atakanemre.Ecommerce.model.RegisterBody
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<RegisterBody, AppResult<CRUD>>() {
    override suspend fun execute(params: RegisterBody): AppResult<CRUD> =
        productRepository.register(params)
}