package com.stlhorizon.stlmovie.domain

import com.stlhorizon.stlmovie.data.remote.response.topRatedMoviesResponse
import com.stlhorizon.stlmovie.data.repository.MovieRepository
import com.stlhorizon.stlmovie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTopRatedMoviesUseCase  @Inject constructor(private val repository: MovieRepository){
    operator fun invoke():Flow<Resource<topRatedMoviesResponse>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getTopRatedMoviesResponse()
            emit(Resource.Success(result))
        }catch (e:IOException){
            emit(Resource.Error("No internet Connection"))

        }catch (e:HttpException){
            emit(Resource.Error("An Error Occured"))
        }
    }
}