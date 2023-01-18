package com.jihunyun.hiltmvvmretrofitrecyclerview.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jihunyun.hiltmvvmretrofitrecyclerview.model.ResponseSimpleList
import com.jihunyun.hiltmvvmretrofitrecyclerview.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: MainUseCase): ViewModel() {

    private val _imgList = MutableLiveData<List<ResponseSimpleList.Item>?>()
    val imgList: LiveData<List<ResponseSimpleList.Item>?> = _imgList

    init {
        viewModelScope.launch {
            useCase.invoke().collect {
                _imgList.value = it.items
            }
        }
    }
}