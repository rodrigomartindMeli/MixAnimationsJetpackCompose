package com.rodrigodominguez.rappitest.listfilms.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rodrigodominguez.rappitest.data.Result
import com.rodrigodominguez.rappitest.listfilms.data.FilmsRepository
import kotlinx.coroutines.Dispatchers

class FilmsViewModel(
    private val repository: FilmsRepository
) : ViewModel() {
    var year: String = "2019"
    fun getFilms() = liveData(Dispatchers.IO) {
        emit(Result.Resource.loading(data = null))
        try {
            emit(Result.Resource.success(data = repository.getFilms(year)))
        } catch (exception: Exception) {
            emit(
                Result.Resource.error(
                    data = null,
                    message = exception.message ?: "Error Occurred!"
                )
            )
        }
    }

    /***
     * Se agrega este metodo para actualizar el listado de mejores peliculas segun el año
     * que pueda elegir el user, por defecto busca las mejores peliculas de 2019
     * */
    fun updateYear(newYear: String){
        year = newYear
        getFilms()
    }
}