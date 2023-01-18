package com.jihunyun.hiltmvvmretrofitrecyclerview.usecase

import com.jihunyun.hiltmvvmretrofitrecyclerview.model.ResponseSimpleList
import com.jihunyun.hiltmvvmretrofitrecyclerview.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(private val repository: MainRepository) {
    operator fun invoke(): Flow<ResponseSimpleList> = repository.getSimpleList()
}