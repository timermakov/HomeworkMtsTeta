package com.timermakov.homeworkmtsteta.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timermakov.homeworkmtsteta.R

class GenreAdapter(
    private val dataList: MutableList<String>,
    private val listener: (item: String) -> Unit
) : RecyclerView.Adapter<GenreAdapter.GenreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
        return GenreHolder(view)
    }

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        holder.textField.text = dataList[position]
        holder.itemView.setOnClickListener {
            listener(dataList[position])
        }
    }

    // get amount of genres
    override fun getItemCount(): Int = dataList.size

    // make connection with XML element
    class GenreHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textField: TextView = view.findViewById(R.id.genreTextView)
    }

}