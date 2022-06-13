package com.stlhorizon.stlmovie.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stlhorizon.stlmovie.data.remote.response.topRatedMoviesResponse
import com.stlhorizon.stlmovie.domain.GetTopRatedMoviesUseCase
import com.stlhorizon.stlmovie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {
    private var _topRatedMovieResponse = MutableLiveData<Resource<topRatedMoviesResponse>>()
    val topRatedMoviesResponse: LiveData<Resource<topRatedMoviesResponse>>
    get() = _topRatedMovieResponse

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
}
