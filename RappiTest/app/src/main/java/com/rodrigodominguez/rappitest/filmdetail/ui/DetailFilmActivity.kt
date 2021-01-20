package com.rodrigodominguez.rappitest.filmdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rodrigodominguez.rappitest.R
import com.rodrigodominguez.rappitest.api.FilmsHelper
import com.rodrigodominguez.rappitest.api.RetrofitBuilder
import com.rodrigodominguez.rappitest.data.Result
import com.rodrigodominguez.rappitest.databinding.ActivityDetailFilmBinding
import com.rodrigodominguez.rappitest.filmdetail.data.Backdrop
import com.rodrigodominguez.rappitest.filmdetail.data.FilmItemResponse
import com.rodrigodominguez.rappitest.listfilms.ui.FilmsAdapter
import com.rodrigodominguez.rappitest.listfilms.ui.ImagesAdapter
import com.rodrigodominguez.rappitest.util.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {
    private lateinit var adapterImages: ImagesAdapter
    private lateinit var binding: ActivityDetailFilmBinding
    private var pathHeader: String? = ""
    private var pathPoster: String? = ""
    private var idFilm: String? = ""
    private lateinit var viewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        supportActionBar?.hide()
        val bundle = intent.extras
        if (bundle != null) {
            idFilm = bundle.getString(ID)
            pathPoster = bundle.getString(PATH_POSTER)
            pathHeader = bundle.getString(PATH_HEADER)
        }
        binding.imageViewBackButton.setOnClickListener { onBackPressed() }
        if (idFilm == null) {
            Toast.makeText(this, R.string.ups_detail_film, Toast.LENGTH_SHORT).show()
            finish()
        } else {
            loadImages()
            setupViewModel()
            setupObservers()
        }
    }

    private fun loadImages() {
        Glide.with(this)
            .load(URL_BASE_IMAGES + pathHeader)
            .centerCrop()
            .into(binding.imageViewBackdropPath)

        Glide.with(this)
            .load(URL_BASE_IMAGES + pathPoster)
            .centerCrop()
            .into(binding.imageViewPoster)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(FilmsHelper(RetrofitBuilder.apiService))
        ).get(FilmViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getFilm(idFilm!!).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Result.Status.SUCCESS -> {
                        resource.data?.let { film -> updateUI(film) }
                        setupListeners()
                    }
                    Result.Status.ERROR -> {
                        binding.progressBarDetail.visibility = View.GONE
                    }
                    Result.Status.LOADING -> {
                        binding.progressBarDetail.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun setupListeners() {
    }

    private fun updateUI(film: FilmItemResponse) {
        binding.textViewTitle.text = film.title
        binding.textViewDescription.text = film.overview
        binding.textViewDetailPopularity.text = film.vote_average.toString()
        binding.textViewDetailReleaseDate.text = film.release_date
        binding.textViewDetailLanguage.text = film.original_language.toUpperCase()
        film.images?.backdrops?.let {
            binding.recyclerImages.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            adapterImages = ImagesAdapter(it)
            binding.recyclerImages.adapter = adapterImages
        }

        binding.motionLayout.transitionToState(R.id.end)
    }

    companion object {
        const val ID = "id_film"
        const val PATH_POSTER = "path_poster"
        const val PATH_HEADER = "path_header"
        const val URL_BASE_IMAGES = "https://image.tmdb.org/t/p/w300"
    }
}