package com.bilalqwatly.kroma.data.remote.repository



import com.bilalqwatly.kroma.data.remote.api.RetrofitService
import com.bilalqwatly.kroma.data.remote.networkchecker.INetworkChecker
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val networkChecker: INetworkChecker
) {


//    suspend fun getSlider(section: String): Either<BaseException, ArrayList<SliderModel>> {
//        if (networkChecker.isConnected) {
//            return try {
//                val response = retrofitService.getSlider(section)
//                HandleBaseResponse<ArrayList<SliderModel>>().handleBaseResponse(response)
//            } catch (e: Exception) {
//                Either.Left(
//                    BaseException()
//                )
//            }
//
//        }
//        return Either.Left(
//            BaseException()
//        )
//
//    }



}