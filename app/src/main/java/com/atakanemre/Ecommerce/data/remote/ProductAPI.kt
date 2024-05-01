package com.atakanemre.Ecommerce.data.remote

import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.model.AddToCardRequest
import com.atakanemre.Ecommerce.model.CRUD
import com.atakanemre.Ecommerce.model.Category
import com.atakanemre.Ecommerce.model.ClearBagBody
import com.atakanemre.Ecommerce.model.DeleteCartRequest
import com.atakanemre.Ecommerce.model.LoginBody
import com.atakanemre.Ecommerce.model.LoginResponse
import com.atakanemre.Ecommerce.model.Product
import com.atakanemre.Ecommerce.model.RegisterBody
import com.atakanemre.Ecommerce.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductAPI {

    @GET("get_products.php")
    suspend fun getProductData(): AppResult<Product>

    @GET("get_cart_products.php")
    suspend fun getBagProductsData(
        @Query("userId") userId: String
    ): AppResult<Product>

    @GET("get_sale_products.php")
    suspend fun getSaleProductData(): AppResult<Product>

    @GET("search_product.php")
    suspend fun searchProduct(
        @Query("query") query: String
    ): AppResult<Product>

    @POST("add_to_cart.php")
    suspend fun addToBag(
        @Body addToCardRequest: AddToCardRequest
    ): AppResult<CRUD>

    @POST("delete_from_cart.php")
    suspend fun deleteProductFromBag(
        @Body deleteCartRequest: DeleteCartRequest
    ): AppResult<CRUD>

    @GET("get_products_by_category.php")
    suspend fun getCategory(
        @Query("category") category: String
    ): AppResult<Product>

    @GET("get_categories.php")
    suspend fun getCategoryName(): AppResult<Category>

    @POST("sign_in.php")
    suspend fun login(
        @Body loginBody: LoginBody
    ): AppResult<LoginResponse>

    @POST("sign_up.php")
    suspend fun register(
        @Body registerBody: RegisterBody
    ): AppResult<CRUD>

    @GET("get_user.php")
    suspend fun getUser(
        @Query("userId") userId: String
    ): AppResult<UserResponse>

    @POST("clear_cart.php")
    suspend fun clearBag(
        @Body clearBagBody: ClearBagBody
    ): AppResult<CRUD>
}