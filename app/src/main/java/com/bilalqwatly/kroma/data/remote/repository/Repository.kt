package com.bilalqwatly.kroma.data.remote.repository


import com.bilalqwatly.kroma.data.exception.BaseException
import com.bilalqwatly.kroma.data.remote.api.RetrofitService
import com.bilalqwatly.kroma.data.remote.api.model.request.MainRequest
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.data.remote.functional.Either
import com.bilalqwatly.kroma.data.remote.networkchecker.INetworkChecker
import com.bilalqwatly.kroma.domin.interactor.usecase.base.HandleBaseResponse
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val networkChecker: INetworkChecker
) {


    suspend fun getMain(
        mainRequest: MainRequest,
    ): Either<BaseException, ArrayList<ResultData>> {
        if (networkChecker.isConnected) {
            return try {
                val response = retrofitService.getMain(
                    mainRequest.all_sections,
                    mainRequest.period,
                    mainRequest.api_key
                )
                HandleBaseResponse<ArrayList<ResultData>>().handleBaseResponse(response)
            } catch (e: Exception) {
                Either.Left(
                    BaseException()
                )
            }

        }
        return Either.Left(
            BaseException()
        )

    }


}