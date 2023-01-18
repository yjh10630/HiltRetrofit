package com.jihunyun.hiltmvvmretrofitrecyclerview.network

import com.jihunyun.hiltmvvmretrofitrecyclerview.model.ResponseSimpleList
import retrofit2.http.GET

interface ApiService  {
    @GET("simpleList")
    suspend fun simpleList(): ResponseSimpleList
}