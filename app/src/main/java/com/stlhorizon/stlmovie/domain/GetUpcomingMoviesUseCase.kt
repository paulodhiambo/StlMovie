package com.stlhorizon.stlmovie.domain

import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.local.model.UpcomingMovie
import com.stlhorizon.stlmovie.data.repository.MovieRepository
import com.stlhorizon.stlmovie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun  invoke(): Flow<Resource<List<UpcomingMovie>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getUpcomingMovies()
            result.results.forEach { movie->
                repository.saveMovie(movie.toUpcomingMovie())
            }
            val response = repository.getUpcomingMovie()
            emit(Resource.Success(response))

        }catch (e: IOException){
            val response = repository.getUpcomingMovie()
            emit(Resource.Success(response))
        }catch (e:Error){
            emit(Resource.Error("An Error Occured"))
        }
    }
}