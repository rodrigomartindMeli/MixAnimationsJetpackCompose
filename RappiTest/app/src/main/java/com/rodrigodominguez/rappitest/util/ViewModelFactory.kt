package com.rodrigodominguez.rappitest.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rodrigodominguez.rappitest.api.FilmsHelper
import com.rodrigodominguez.rappitest.filmdetail.ui.FilmViewModel
import com.rodrigodominguez.rappitest.listfilms.data.FilmsRepository
import com.rodrigodominguez.rappitest.listfilms.ui.FilmsViewModel

class ViewModelFactory(private val apiHelper: FilmsHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmsViewModel::class.java)) {
            return FilmsViewModel(FilmsRepository(apiHelper)) as T
        }

        if (modelClass.isAssignableFrom(FilmViewModel::class.java)) {
            return FilmViewModel(FilmsRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}