package com.bilalqwatly.kroma.domin.interactor.usecase.main

import com.bilalqwatly.kroma.data.exception.BaseException
import com.bilalqwatly.kroma.data.remote.api.model.request.MainRequest
import com.bilalqwatly.kroma.data.remote.api.model.response.ResultData
import com.bilalqwatly.kroma.data.remote.functional.Either
import com.bilalqwatly.kroma.data.remote.repository.Repository
import com.bilalqwatly.kroma.domin.interactor.usecase.base.CoroutineScopeUseCase
import javax.inject.Inject


class MainUseCase @Inject constructor(
    private val repository: Repository
) :
    CoroutineScopeUseCase<ArrayList<ResultData>, MainRequest>() {
    override suspend fun run(params: MainRequest):
            Either<BaseException, ArrayList<ResultData>> = repository.getMain(params)
}

