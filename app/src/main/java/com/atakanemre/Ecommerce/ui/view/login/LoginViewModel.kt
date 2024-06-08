package com.atakanemre.Ecommerce.ui.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.usecases.login.LoginUseCase
import com.atakanemre.Ecommerce.model.LoginBody
import com.atakanemre.Ecommerce.model.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var loginLiveData = MutableLiveData<AppResult<LoginResponse>>()

    fun login(loginBody: LoginBody){
        viewModelScope.launch {
            val result = loginUseCase(loginBody)
            loginLiveData.postValue(result)
        }
    }
}