package com.atakanemre.Ecommerce.domain.usecases.profile

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.SuspendUseCase
import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.UserResponse
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : SuspendUseCase<UseParams, AppResult<UserResponse>>() {
    override suspend fun execute(params: UseParams): AppResult<UserResponse> =
        productRepository.getUser(params.userId)
}

data class UseParams(val userId: String)