package com.atakanemre.Ecommerce.domain.repos

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.model.AddToCardRequest
import com.atakanemre.Ecommerce.model.CRUD
import com.atakanemre.Ecommerce.model.Category
import com.atakanemre.Ecommerce.model.ClearBagBody
import com.atakanemre.Ecommerce.model.LoginBody
import com.atakanemre.Ecommerce.model.LoginResponse
import com.atakanemre.Ecommerce.model.Product
import com.atakanemre.Ecommerce.model.ProductEntity
import com.atakanemre.Ecommerce.model.RegisterBody
import com.atakanemre.Ecommerce.model.UserResponse

interface ProductRepository {

    suspend fun getProducts(): AppResult<Product>

    suspend fun getBagProducts(userId: String): AppResult<Product>

    suspend fun getSaleProduct(): AppResult<Product>

    suspend fun searchProduct(query: String): AppResult<Product>

    suspend fun addToBag(addToCardRequest: AddToCardRequest): AppResult<CRUD>

    suspend fun deleteToProductFromBag(itemId: Int): AppResult<CRUD>

    suspend fun clearBag(clearBagBody: ClearBagBody): AppResult<CRUD>

    suspend fun getCategory(category: String): AppResult<Product>

    suspend fun getCategoryName(): AppResult<Category>

    suspend fun addToFavorite(productEntity: ProductEntity)

    suspend fun deleteFromFavorites(productEntity: ProductEntity)

    suspend fun getFavoriteProducts(): List<ProductEntity>

    suspend fun login(loginBody: LoginBody): AppResult<LoginResponse>

    suspend fun register(registerBody: RegisterBody): AppResult<CRUD>

    suspend fun getUser(userId: String): AppResult<UserResponse>
}