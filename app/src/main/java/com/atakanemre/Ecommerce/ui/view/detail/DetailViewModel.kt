package com.atakanemre.Ecommerce.ui.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.usecases.detail.AddToBagUseCase
import com.atakanemre.Ecommerce.model.AddToCardRequest
import com.atakanemre.Ecommerce.model.CRUD
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val addToBagUseCase: AddToBagUseCase
) :
    ViewModel() {

    var addBagLiveData = MutableLiveData<AppResult<CRUD>>()

    fun addToBag(addToCardRequest: AddToCardRequest) {
        viewModelScope.launch {
            val result: AppResult<CRUD> = addToBagUseCase(addToCardRequest)
            addBagLiveData.postValue(result)
        }
    }
}