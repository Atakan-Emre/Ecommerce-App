package com.atakanemre.Ecommerce.ui.view.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.usecases.register.RegisterUseCase
import com.atakanemre.Ecommerce.model.CRUD
import com.atakanemre.Ecommerce.model.RegisterBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    var registerLiveData = MutableLiveData<AppResult<CRUD>>()

    fun register(registerBody: RegisterBody) {
        viewModelScope.launch {
            val result = registerUseCase(registerBody)
            registerLiveData.postValue(result)
        }
    }
}