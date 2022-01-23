package com.jan.melichallenge.apimanager.product

import com.jan.melichallenge.apimanager.MeliApiServices
import com.jan.melichallenge.apimanager.util.stringSuspending
import com.jan.melichallenge.data.product.ProductRemoteDataSource
import com.jan.melichallenge.domain.Error.NetworkError
import com.jan.melichallenge.domain.Error.UnknownError
import com.jan.melichallenge.domain.Result
import retrofit2.HttpException

/**
 *  Class to implement ProductRemoteDataSource interface
 *  @author Jaime Trujillo
 */
class ProductRemoteDataSourceImpl(private val meliApiServices: MeliApiServices) :
    ProductRemoteDataSource {

    override suspend fun searchProducts(query: String, offset: Int) = try {
        val result = meliApiServices.searchProducts(query, offset).results.map {
            it.toProductDomain()
        }
        Result.Success(result)
    } catch (httpException: HttpException) {
        Result.Failure(NetworkError(httpException.response()?.errorBody()?.stringSuspending()))
    } catch (exception: Exception) {
        Result.Failure(UnknownError(exception))
    }
}
