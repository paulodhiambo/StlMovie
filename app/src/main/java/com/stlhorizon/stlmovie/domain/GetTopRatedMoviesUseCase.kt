package com.stlhorizon.stlmovie.domain

import com.stlhorizon.stlmovie.data.remote.response.Movie
import com.stlhorizon.stlmovie.data.remote.response.topRatedMoviesResponse
import com.stlhorizon.stlmovie.data.repository.MovieRepository
import com.stlhorizon.stlmovie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTopRatedMoviesUseCase  @Inject constructor(private val repository: MovieRepository){
    operator fun invoke():Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getTopRatedMoviesResponse()
            result.results.forEach { movie->
                repository.saveMovie(movie)
            }
            val response = repository.getMovie()
            emit(Resource.Success(response))
        }catch (e:IOException){
            val response = repository.getMovie()
            emit(Resource.Success(response))

        }catch (e:HttpException){
            emit(Resource.Error("An Error Occured"))
        }
    }
}