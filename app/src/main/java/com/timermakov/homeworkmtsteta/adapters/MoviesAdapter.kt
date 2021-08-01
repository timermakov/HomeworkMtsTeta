package com.timermakov.homeworkmtsteta.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.timermakov.homeworkmtsteta.R
import com.timermakov.homeworkmtsteta.dto.MovieDto

class MoviesAdapter(
    private val dataList: List<MovieDto>,
    private val listener: (item: MovieDto) -> Unit,
    private val imgMetrics: Pair<Int, Int>?
) : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        val holder = MoviesHolder(view)

        // to make images as big as possible with fixed offsets
        if (imgMetrics != null) {
            val layoutParams = holder.poster.layoutParams
            layoutParams.width = imgMetrics.first
            layoutParams.height = imgMetrics.second
            holder.poster.layoutParams = layoutParams
        }

        // to round corners of poster
        holder.poster.clipToOutline = true

        return MoviesHolder(view)
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {

        // initialization from MoviesDataSourceImpl
        val item = dataList[position]
        holder.poster.load(item.imageUrl)
        holder.title.text = item.title
        holder.description.text = item.description
        holder.ageRestriction.text = "${item.ageRestriction}+"

        // set rating as making stars black from first to rateScore and white for others (from last to rateScore)
        for (i in 0 until item.rateScore) {
            holder.rating[i].setImageDrawable(holder.itemView.context.getDrawable(R.drawable.ic_star_black))
        }
        for (i in 4 downTo item.rateScore) {
            holder.rating[i].setImageDrawable(holder.itemView.context.getDrawable(R.drawable.ic_star_white))
        }

        // movie click listener
        holder.itemView.setOnClickListener {
            listener(dataList[position])
        }
    }

    // get amount of movies
    override fun getItemCount(): Int = dataList.size

    // make connections with XML elements
    class MoviesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster: ImageView = view.findViewById(R.id.previewPosterImageView)
        val title: TextView = view.findViewById(R.id.titleTextView)
        val description: TextView = view.findViewById(R.id.previewDescriptionTextView)
        val rating: List<ImageView> = listOf(
            view.findViewById(R.id.previewFirstStar),
            view.findViewById(R.id.previewSecondStar),
            view.findViewById(R.id.previewThirdStar),
            view.findViewById(R.id.previewFourthStar),
            view.findViewById(R.id.previewFifthStar)
        )
        val ageRestriction: TextView = view.findViewById(R.id.previewAgeLimitTextView)
    }

}