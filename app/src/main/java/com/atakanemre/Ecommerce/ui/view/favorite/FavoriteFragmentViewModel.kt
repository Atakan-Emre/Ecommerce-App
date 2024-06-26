package com.atakanemre.Ecommerce.ui.view.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanemre.Ecommerce.domain.usecases.favoirte.DeleteProductFromFavoriteUseCase
import com.atakanemre.Ecommerce.domain.usecases.favoirte.GetFavoriteProductUseCase
import com.atakanemre.Ecommerce.model.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteFragmentViewModel @Inject constructor(
    private val getFavoriteProductUseCase: GetFavoriteProductUseCase,
    private val deleteFavoriteProductUseCase: DeleteProductFromFavoriteUseCase
) : ViewModel() {

    var getFavoriteLiveData = MutableLiveData<List<ProductEntity>>()
    var deleteProductFromFavoriteLiveData = MutableLiveData<Unit>()

    fun getFavorite() {
        viewModelScope.launch {
            val result = getFavoriteProductUseCase(Unit)
            getFavoriteLiveData.postValue(result)
        }
    }

    fun deleteProductFromFavorite(productEntity: ProductEntity) {
        viewModelScope.launch {
            val result = deleteFavoriteProductUseCase(productEntity)
            deleteProductFromFavoriteLiveData.postValue(result)
            getFavorite()
        }
    }
}