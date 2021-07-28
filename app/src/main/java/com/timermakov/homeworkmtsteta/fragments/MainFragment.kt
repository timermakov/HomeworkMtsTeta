package com.timermakov.homeworkmtsteta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.timermakov.homeworkmtsteta.R
import com.timermakov.homeworkmtsteta.adapters.GenreAdapter
import com.timermakov.homeworkmtsteta.adapters.MoviesAdapter
import com.timermakov.homeworkmtsteta.calculateImageSizeInPX
import com.timermakov.homeworkmtsteta.dto.MovieDto
import com.timermakov.homeworkmtsteta.functions.replaceFragment
import com.timermakov.homeworkmtsteta.movies.MoviesDataSourceImpl
import com.timermakov.homeworkmtsteta.movies.MoviesModel

class MainFragment : Fragment() {

    private lateinit var recyclerViewGenres: RecyclerView
    private lateinit var recyclerViewMovies: RecyclerView

    private val moviesModel = MoviesModel(MoviesDataSourceImpl())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    // initialization
    private fun initViews() {
        recyclerViewGenres = requireView().findViewById(R.id.popularGenreRecyclerView)
        val adapterGenres = GenreAdapter(getGenres(), this::adapterGenreListener)
        recyclerViewGenres.adapter = adapterGenres

        recyclerViewMovies = requireView().findViewById(R.id.moviesRecyclerView)
        val adapterMovies = MoviesAdapter(
            moviesModel.getMovies(),
            this::adapterMovieListener,
            calculateImageSizeInPX(requireContext())
        )
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
        replaceFragment(requireActivity(), MovieDetailsFragment.newInstance(item), true)
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
            else -> Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}