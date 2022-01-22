package com.bilalqwatly.kroma.data.remote.api


import com.bilalqwatly.kroma.data.remote.api.ApiEndPoints.MAIN_URL
import com.bilalqwatly.kroma.data.remote.api.model.response.BaseResponseData
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import retrofit2.http.*

interface RetrofitService {


    @GET("$MAIN_URL{all-sections}/{period}.json")
    suspend fun getMain(
        @Path(value = "all-sections", encoded = true) all_sections: String,
        @Path(value = "period", encoded = true) period: Int,
        @Query(value = "api-key") api_key: String,
    ): BaseResponseData<ArrayList<ResultData>>


}