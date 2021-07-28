package com.timermakov.homeworkmtsteta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.timermakov.homeworkmtsteta.R
import com.timermakov.homeworkmtsteta.adapters.GenreAdapter


class ProfileFragment : Fragment() {

    private lateinit var recyclerViewInterests: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews() {
        recyclerViewInterests = requireView().findViewById(R.id.profileInterestsRecyclerView)
        val adapter = GenreAdapter(getGenres(), this::adapterGenreListener)
        recyclerViewInterests.adapter = adapter
    }

    private fun getGenres(): MutableList<String> {
        return mutableListOf("боевики", "драмы", "комедии")
    }

    private fun adapterGenreListener(item: String) {
        // do nothing
    }

}