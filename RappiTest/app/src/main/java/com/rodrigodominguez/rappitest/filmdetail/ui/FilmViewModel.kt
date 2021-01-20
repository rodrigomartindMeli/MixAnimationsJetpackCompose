package com.rodrigodominguez.rappitest.filmdetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rodrigodominguez.rappitest.data.Result
import com.rodrigodominguez.rappitest.listfilms.data.FilmsRepository
import kotlinx.coroutines.Dispatchers

class FilmViewModel(private val repository: FilmsRepository) : ViewModel() {

    fun getFilm(id: String) = liveData(Dispatchers.IO) {
        emit(Result.Resource.loading(data = null))
        try {
            emit(Result.Resource.success(data = repository.getFilm(id)))
        } catch (exception: Exception) {
            emit(
                Result.Resource.error(
                    data = null,
                    message = exception.message ?: "Error Occurred!"
                )
            )
        }
    }
}