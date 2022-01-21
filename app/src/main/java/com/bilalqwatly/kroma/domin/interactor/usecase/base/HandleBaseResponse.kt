package com.bilalqwatly.kroma.domin.interactor.usecase.base


import com.bilalqwatly.kroma.data.exception.BaseException
import com.bilalqwatly.kroma.data.remote.api.model.response.BaseResponseData
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.data.remote.functional.Either
import com.bilalqwatly.kroma.utils.constants.DataConstants.API_RESULT_OK

open class HandleBaseResponse {

    suspend fun handleBaseResponse(baseResponseData: BaseResponseData):
            Either<BaseException, ArrayList<ResultData>> {
        return if (baseResponseData.status.equals(API_RESULT_OK)) {

            Either.Right(baseResponseData.results);
        } else {
            Either.Left(BaseException("Error"));

        }
    }
}