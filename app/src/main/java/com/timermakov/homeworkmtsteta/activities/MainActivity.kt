package com.timermakov.homeworkmtsteta.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.timermakov.homeworkmtsteta.R
import com.timermakov.homeworkmtsteta.adapters.GenreAdapter
import com.timermakov.homeworkmtsteta.adapters.MoviesAdapter
import com.timermakov.homeworkmtsteta.dto.MovieDto
import com.timermakov.homeworkmtsteta.movies.MoviesDataSourceImpl
import com.timermakov.homeworkmtsteta.movies.MoviesModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewGenres: RecyclerView
    private lateinit var recyclerViewMovies: RecyclerView

    private val moviesModel = MoviesModel(MoviesDataSourceImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    // initialization
    private fun initViews() {
        recyclerViewGenres = findViewById(R.id.popularGenreRecyclerView)
        val adapterGenres = GenreAdapter(getGenres(), this::adapterGenreListener)
        recyclerViewGenres.adapter = adapterGenres

        recyclerViewMovies = findViewById(R.id.moviesRecyclerView)
        val adapterMovies = MoviesAdapter(moviesModel.getMovies(), this::adapterMovieListener, this)
        recyclerViewMovies.adapter = adapterMovies
    }

    // get a list of different genres
    private fun getGenres(): MutableList<String> {
        return mutableListOf(
            "боевики",
            "драмы",
            "комедии",
            "артхаус",
            "мелодрамы",
            "приключения",
            "мультики",
            "детективы",
            "криминал",
            "документальное",
            "фантастика",
            "ужасы",
            "мистика",
            "триллеры"
        )
    }

    // make a message after click on movie item
    private fun adapterMovieListener(item: MovieDto) {
        showToast(item.title)
    }

    // make a message after click on genre item
    private fun adapterGenreListener(item: String) {
        showToast(item)
    }

    // show a floating message
    private fun showToast(message: String?) {
        when {
            message.isNullOrEmpty() -> {
                showToast("Пустое сообщение")
            }
            else -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

}