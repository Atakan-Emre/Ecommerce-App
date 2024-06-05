package com.atakanemre.Ecommerce.util.retrofit

import com.atakanemre.Ecommerce.domain.AppResult
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

internal class ResultCallAdapter(
    private val resultType: Type,
    private val coroutineScope: CoroutineScope
) : CallAdapter<Type, Call<AppResult<Type>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<Type>): Call<AppResult<Type>> {
        return ResultCall(call, coroutineScope)
    }
}