package com.bilalqwatly.kroma.data.remote.api.model.response

import com.google.gson.annotations.SerializedName

open class BaseResponseData<T> {

    @SerializedName("status")
    var status: String? = null
        private set

    @SerializedName("copyright")
    var copyright: String? = null
        private set

    @SerializedName("num_results")
    var numResults: Int? = null
        private set

    @SerializedName("results")
    var results: T? = null
        private set

}