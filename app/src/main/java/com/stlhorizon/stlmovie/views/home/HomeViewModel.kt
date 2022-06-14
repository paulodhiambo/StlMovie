package com.stlhorizon.stlmovie.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.local.model.TopRatedMovie
import com.stlhorizon.stlmovie.data.local.model.UpcomingMovie
import com.stlhorizon.stlmovie.domain.GetPopularMoviesUsecase
import com.stlhorizon.stlmovie.domain.GetTopRatedMoviesUseCase
import com.stlhorizon.stlmovie.domain.GetUpcomingMoviesUseCase
import com.stlhorizon.stlmovie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesUseCase: GetTopRatedMoviesUseCase,
    private val getPopularMoviesUsecase: GetPopularMoviesUsecase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {
    private var _topRatedMovieResponse = MutableLiveData<Resource<List<TopRatedMovie>>>()
    val topRatedMoviesResponse: LiveData<Resource<List<TopRatedMovie>>>
    get() = _topRatedMovieResponse

    private var _popularMovieResponse = MutableLiveData<Resource<List<PopularMovie>>>()
    val popularMoviesResponse: LiveData<Resource<List<PopularMovie>>>
        get() = _popularMovieResponse

    private var _upcomingMovieResponse = MutableLiveData<Resource<List<UpcomingMovie>>>()
    val upcomingMoviesResponse: LiveData<Resource<List<UpcomingMovie>>>
        get() = _upcomingMovieResponse

    fun getTopRatedMovies(){
        moviesUseCase().onEach { result->
            when (result){
                is Resource.Success->{
                   _topRatedMovieResponse.value = Resource.Success(result.data!!)
                }
                is Resource.Loading->{
                    _topRatedMovieResponse.value = Resource.Loading()

                }
                is Resource.Error->{
                    _topRatedMovieResponse.value = Resource.Error(result.message!!)

                }
            }
        }.launchIn(viewModelScope)
    }

    fun getPopularMovies(){
        getPopularMoviesUsecase().onEach { result ->
            when (result){
                is Resource.Success->{
                    _popularMovieResponse.value = Resource.Success(result.data!!)
                } is Resource.Loading->{
                    _popularMovieResponse.value = Resource.Loading()
                } is Resource.Error->{
                    _popularMovieResponse.value = Resource.Error(result.message!!)
                }

            }
        }.launchIn(viewModelScope)
    }
    fun getUpcomingMovies(){
        getUpcomingMoviesUseCase().onEach { result ->
            when (result){
                is Resource.Success->{
                    _upcomingMovieResponse.value = Resource.Success(result.data!!)
                } is Resource.Loading->{
                    _upcomingMovieResponse.value = Resource.Loading()
                } is Resource.Error->{
                    _upcomingMovieResponse.value = Resource.Error(result.message!!)
                }

            }
        }.launchIn(viewModelScope)
    }
}
