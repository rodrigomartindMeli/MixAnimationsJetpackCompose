package com.rodrigodominguez.rappitest.listfilms.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rodrigodominguez.rappitest.R
import com.rodrigodominguez.rappitest.filmdetail.ui.DetailFilmActivity
import com.rodrigodominguez.rappitest.filmdetail.ui.DetailFilmActivity.Companion.ID
import com.rodrigodominguez.rappitest.filmdetail.ui.DetailFilmActivity.Companion.PATH_HEADER
import com.rodrigodominguez.rappitest.filmdetail.ui.DetailFilmActivity.Companion.PATH_POSTER
import com.rodrigodominguez.rappitest.listfilms.data.FilmItem
import kotlinx.android.synthetic.main.item_layout.view.*

class FilmsAdapter(private val films: ArrayList<FilmItem>) :
    RecyclerView.Adapter<FilmsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(film: FilmItem) {
            itemView.apply {
                textViewFilmTitle.text = film.title
                textViewFilmOverview.text = film.overview
                textViewLanguage.text = film.originalLanguage.toUpperCase()
                textViewPopulary.text = film.voteAverage.toString()
                textViewRelaseDate.text = film.releaseDate
                val pathUrl = film.posterPath ?: film.backdropPath
                Glide.with(imageViewAvatar.context)
                    .load("https://image.tmdb.org/t/p/w200$pathUrl")
                    .placeholder(R.drawable.image_24px)
                    .centerCrop()
                    .into(imageViewAvatar)
                setOnClickListener {
                    val intent =  Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(ID, film.id.toString())
                    intent.putExtra(PATH_POSTER, film.posterPath)
                    intent.putExtra(PATH_HEADER, film.backdropPath)
                    itemView.context.startActivity(intent);
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = films.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(films[position])
    }

    fun addFilms(films: List<FilmItem>) {
        this.films.apply {
            clear()
            addAll(films)
        }
    }
}