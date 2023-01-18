package com.jihunyun.hiltmvvmretrofitrecyclerview.model


import com.google.gson.annotations.SerializedName

data class ResponseSimpleList(
    @SerializedName("items") var items: List<Item>? = null
) {
    data class Item(
        @SerializedName("imageUrl") var imageUrl: String? = null
    )
}