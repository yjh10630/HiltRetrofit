package com.jihunyun.hiltmvvmretrofitrecyclerview.repository

import android.util.Log
import com.jihunyun.hiltmvvmretrofitrecyclerview.model.ResponseSimpleList
import com.jihunyun.hiltmvvmretrofitrecyclerview.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {
    fun getSimpleList(): Flow<ResponseSimpleList> = flow {
        emit(apiService.simpleList())
    }
        .flowOn(Dispatchers.IO)
        .catch {
            Log.e("####", "simpleList Api Error ${it.message}")
        }
}