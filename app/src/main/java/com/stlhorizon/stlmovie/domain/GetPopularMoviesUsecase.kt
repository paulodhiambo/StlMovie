package com.stlhorizon.stlmovie.domain

import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.repository.MovieRepository
import com.stlhorizon.stlmovie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUsecase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<Resource<List<PopularMovie>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getPopularMovies()
            result.results.forEach { movie->
                repository.saveMovie(movie.toMovie())
            }
            val response = repository.getPopularMovie()
            emit(Resource.Success(response))
        }catch (e: IOException){
            val response = repository.getPopularMovie()
            emit(Resource.Success(response))
        }catch (e: Error){
            emit(Resource.Error("An Error Occured"))
        }
    }
}