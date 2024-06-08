package com.atakanemre.Ecommerce.domain.usecases.login

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.LoginBody
import com.atakanemre.Ecommerce.model.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<LoginBody, AppResult<LoginResponse>>() {
    override suspend fun execute(params: LoginBody): AppResult<LoginResponse> =
        productRepository.login(params)
}