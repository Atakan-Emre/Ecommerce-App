package com.atakanemre.Ecommerce.ui.view.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanemre.Ecommerce.domain.AppResult
import com.atakanemre.Ecommerce.domain.usecases.profile.ProfileUseCase
import com.atakanemre.Ecommerce.domain.usecases.profile.UseParams
import com.atakanemre.Ecommerce.model.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase
) : ViewModel() {

    var getUserLiveData = MutableLiveData<AppResult<UserResponse>>()

    fun getUser(userId:String){
        viewModelScope.launch {
            val result = profileUseCase(UseParams(userId))
            getUserLiveData.postValue(result)
        }
    }
}