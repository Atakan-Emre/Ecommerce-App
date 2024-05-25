package com.atakanemre.Ecommerce.data.repository

import com.atakanemre.Ecommerce.domain.repos.ProductRepository
import com.atakanemre.Ecommerce.model.AddToCardRequest
import com.atakanemre.Ecommerce.model.CRUD
import com.atakanemre.Ecommerce.model.Category
import com.atakanemre.Ecommerce.model.DeleteCartRequest
import com.atakanemre.Ecommerce.model.Product
import com.atakanemre.Ecommerce.data.remote.ProductAPI
import com.atakanemre.Ecommerce.data.local.ProductDao
import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.model.ClearBagBody
import com.atakanemre.Ecommerce.model.LoginBody
import com.atakanemre.Ecommerce.model.LoginResponse
import com.atakanemre.Ecommerce.model.ProductEntity
import com.atakanemre.Ecommerce.model.RegisterBody
import com.atakanemre.Ecommerce.model.UserResponse
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productAPI: ProductAPI,
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun getProducts(): AppResult<Product> = productAPI.getProductData()

    override suspend fun getBagProducts(userId: String): AppResult<Product> =
        productAPI.getBagProductsData(userId)

    override suspend fun getSaleProduct(): AppResult<Product> = productAPI.getSaleProductData()

    override suspend fun searchProduct(query: String): AppResult<Product> =
        productAPI.searchProduct(query)

    override suspend fun addToBag(addToCardRequest: AddToCardRequest): AppResult<CRUD> =
        productAPI.addToBag(addToCardRequest)

    override suspend fun deleteToProductFromBag(itemId: Int): AppResult<CRUD> =
        productAPI.deleteProductFromBag(DeleteCartRequest(itemId))

    override suspend fun clearBag(clearBagBody: ClearBagBody): AppResult<CRUD> =
        productAPI.clearBag(clearBagBody)

    override suspend fun getCategory(category: String): AppResult<Product> =
        productAPI.getCategory(category)

    override suspend fun getCategoryName(): AppResult<Category> = productAPI.getCategoryName()
    override suspend fun addToFavorite(productEntity: ProductEntity) =
        productDao.addFavoriteProduct(productEntity)

    override suspend fun deleteFromFavorites(productEntity: ProductEntity) =
        productDao.deleteFavoriteProduct(productEntity)

    override suspend fun getFavoriteProducts(): List<ProductEntity> =
        productDao.getFavoriteProduct()

    override suspend fun login(loginBody: LoginBody): AppResult<LoginResponse> =
        productAPI.login(loginBody)

    override suspend fun register(registerBody: RegisterBody): AppResult<CRUD> =
        productAPI.register(registerBody)

    override suspend fun getUser(userId: String): AppResult<UserResponse> =
        productAPI.getUser(userId)
}